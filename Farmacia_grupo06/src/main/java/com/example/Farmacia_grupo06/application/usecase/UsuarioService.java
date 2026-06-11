package com.example.Farmacia_grupo06.application.usecase;

import com.example.Farmacia_grupo06.application.dto.command.ActualizarUsuarioCommand;
import com.example.Farmacia_grupo06.application.dto.command.CambiarPasswordCommand;
import com.example.Farmacia_grupo06.application.dto.command.UsuarioCommand;
import com.example.Farmacia_grupo06.application.dto.response.RolResponse;
import com.example.Farmacia_grupo06.application.dto.response.UsuarioResponse;
import com.example.Farmacia_grupo06.application.port.in.UsuarioUseCase;
import com.example.Farmacia_grupo06.domain.exception.rol.RolNotFoundException;
import com.example.Farmacia_grupo06.domain.exception.usuario.PasswordInvalidoException;
import com.example.Farmacia_grupo06.domain.exception.usuario.UsuarioDuplicadoException;
import com.example.Farmacia_grupo06.domain.exception.usuario.UsuarioNotFoundException;
import com.example.Farmacia_grupo06.domain.model.Rol;
import com.example.Farmacia_grupo06.domain.model.Usuario;
import com.example.Farmacia_grupo06.domain.repository.RolRepository;
import com.example.Farmacia_grupo06.domain.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class UsuarioService implements UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository     = rolRepository;
        this.passwordEncoder   = passwordEncoder;
    }

    @Override
    public UsuarioResponse crear(UsuarioCommand command) {
        if (usuarioRepository.existePorUsuario(command.usuario()))
            throw new UsuarioDuplicadoException("username", command.usuario());
        if (usuarioRepository.existePorDni(command.dni()))
            throw new UsuarioDuplicadoException("DNI", command.dni());

        Rol rol = rolRepository.buscarPorId(command.idRol()).orElseThrow(() -> new RolNotFoundException(command.idRol()));

        Usuario usuario = new Usuario(
                null,
                command.nombres(),
                command.apellidos(),
                command.dni(),
                command.usuario(),
                passwordEncoder.encode(command.password()),
                command.telefono(),
                true,
                rol
        );

        return toResponse(usuarioRepository.guardar(usuario));
    }

    @Override
    public UsuarioResponse actualizar(Long id, ActualizarUsuarioCommand command) {
        Usuario usuario = usuarioRepository.buscarPorId(id).orElseThrow(() -> new UsuarioNotFoundException(id));
        Rol rol = rolRepository.buscarPorId(command.idRol()).orElseThrow(() -> new RolNotFoundException(command.idRol()));

        usuario.actualizarDatos(command.nombres(), command.apellidos(),
                command.dni(), command.telefono(), rol);
        return toResponse(usuarioRepository.guardar(usuario));
    }

    @Override
    public UsuarioResponse buscarPorId(Long id) {
        return usuarioRepository.buscarPorId(id)
                .map(this::toResponse)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @Override
    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.listarTodos()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public void cambiarPassword(Long id, CambiarPasswordCommand command) {
        Usuario usuario = usuarioRepository.buscarPorId(id).orElseThrow(() -> new UsuarioNotFoundException(id));

        if (!passwordEncoder.matches(command.passwordActual(), usuario.getPassword()))
            throw new PasswordInvalidoException();

        usuario.cambiarPassword(passwordEncoder.encode(command.passwordNuevo()));
        usuarioRepository.guardar(usuario);
    }

    /*@Override
    public void habilitar(Long id) {
        Usuario usuario = usuarioRepository.buscarPorId(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        usuario.habilitar();
        usuarioRepository.guardar(usuario);
    }

    @Override
    public void deshabilitar(Long id) {
        Usuario usuario = usuarioRepository.buscarPorId(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
        usuario.deshabilitar();
        usuarioRepository.guardar(usuario);
    }*/

    @Override
    public void eliminar(Long id) {
        if (usuarioRepository.buscarPorId(id).isEmpty())
            throw new UsuarioNotFoundException(id);
        usuarioRepository.eliminar(id);
    }

    private UsuarioResponse toResponse(Usuario u) {
        RolResponse rolResponse = new RolResponse(
                u.getRolId().getRolId(),
                u.getRolId().getCodigo(),
                u.getRolId().getNombre()
                //u.getRolId().getHabilitado()
        );
        return new UsuarioResponse(
                u.getUsuarioId(),
                u.getNombre(),
                u.getApellido(),
                u.getDni(),
                u.getUsuario(),
                u.getTelefono(),
                rolResponse
        );
    }

}
