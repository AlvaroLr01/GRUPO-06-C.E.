package com.example.Farmacia_grupo06.infrastructure.persintence.adapter;

import com.example.Farmacia_grupo06.domain.model.Usuario;
import com.example.Farmacia_grupo06.domain.repository.UsuarioRepository;
import com.example.Farmacia_grupo06.infrastructure.mapper.UsuarioMapper;
import com.example.Farmacia_grupo06.infrastructure.persintence.entity.RolEntity;
import com.example.Farmacia_grupo06.infrastructure.persintence.entity.UsuarioEntity;
import com.example.Farmacia_grupo06.infrastructure.persintence.repository.rol.RolJpaRepository;
import com.example.Farmacia_grupo06.infrastructure.persintence.repository.usuario.UsuarioJpaRepository;
import com.example.Farmacia_grupo06.interfaces.util.Constante;
import com.example.Farmacia_grupo06.interfaces.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository usuarioJpaRepository;
    private final RolJpaRepository rolJpaRepository;
    public UsuarioRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository, RolJpaRepository rolJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.rolJpaRepository     = rolJpaRepository;
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioJpaRepository.findById(id).map(UsuarioMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorUsuario(String usuario) {
        return usuarioJpaRepository.findByUsuario(usuario).map(UsuarioMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorDni(String dni) {
        return usuarioJpaRepository.findByDni(dni).map(UsuarioMapper::toDomain);
    }

    @Override
    public boolean existePorUsuario(String usuario) {
        return usuarioJpaRepository.existsByUsuario(usuario);
    }

    @Override
    public boolean existePorDni(String dni) {
        return usuarioJpaRepository.existsByDni(dni);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioJpaRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDomain)
                .toList();
    }

    @Override
    public List<Usuario> listarHabilitados() {
        return usuarioJpaRepository.findByHabilitadoTrue()
                .stream()
                .map(UsuarioMapper::toDomain)
                .toList();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity;
        RolEntity rolEntity = rolJpaRepository.findById(usuario.getRolId().getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        if (usuario.getUsuarioId() != null) {
            entity = usuarioJpaRepository.findById(usuario.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            entity.setNombre(usuario.getNombre());
            entity.setApellido(usuario.getApellido());
            entity.setDni(usuario.getDni());
            entity.setUsuario(usuario.getUsuario());
            entity.setTelefono(usuario.getTelefono());
            entity.setEstado(usuario.getEstado());
            entity.setRolId(rolEntity);
            entity.setPassword(usuario.getPassword());
            entity.setModificado(DateUtil.getCurrentLocalDateTime());

        } else {
            entity = UsuarioMapper.toEntity(usuario, rolEntity);
            entity.setEstado(Constante.HABILITADO);
            entity.setPassword(usuario.getPassword());
            entity.setCreado(DateUtil.getCurrentLocalDateTime());
        }
        UsuarioEntity saved = usuarioJpaRepository.save(entity);
        Usuario usuarioDomain = UsuarioMapper.toDomain(saved);

        return usuarioDomain;
    }

    @Override
    public void eliminar(Long id) {
        usuarioJpaRepository.deleteById(id);
    }
}
