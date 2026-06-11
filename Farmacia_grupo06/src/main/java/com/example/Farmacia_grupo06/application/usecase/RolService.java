package com.example.Farmacia_grupo06.application.usecase;

import com.example.Farmacia_grupo06.application.dto.command.RolCommand;
import com.example.Farmacia_grupo06.application.port.in.RolUseCase;
import com.example.Farmacia_grupo06.domain.exception.rol.RolDuplicadoException;
import com.example.Farmacia_grupo06.domain.exception.rol.RolNotFoundException;
import com.example.Farmacia_grupo06.domain.model.Rol;
import com.example.Farmacia_grupo06.domain.repository.RolRepository;
import com.example.Farmacia_grupo06.interfaces.dto.rol.RolResponse;

import java.util.List;

public class RolService implements RolUseCase {

    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public RolResponse crear(RolCommand command) {
        if (rolRepository.existePorCodigo(command.codigo())) {
            throw new RolDuplicadoException(command.codigo());
        }

        Rol rol = new Rol(null, command.codigo(), command.nombre());
        //Rol rol = new Rol(null, command.codigo(), command.nombre(), true);
        return toResponse(rolRepository.guardar(rol));
    }

    @Override
    public RolResponse actualizar(Long id, RolCommand command) {
        Rol rol = rolRepository.buscarPorId(id).orElseThrow(() -> new RolNotFoundException(id));

        String codigoActual = rol.getCodigo();
        String nuevoCodigo = command.codigo();

        if (codigoActual != null && !codigoActual.equalsIgnoreCase(nuevoCodigo) && rolRepository.existePorCodigo(nuevoCodigo)) {
            throw new RolDuplicadoException(nuevoCodigo);
        }

        rol.setCodigo(nuevoCodigo);
        rol.setNombre(command.nombre());

        return toResponse(rolRepository.guardar(rol));
    }

    @Override
    public RolResponse buscarPorId(Long id) {
        return rolRepository.buscarPorId(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RolNotFoundException(id));
    }

    @Override
    public List<RolResponse> listarTodos() {
        return rolRepository.listarTodos()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    /*@Override
    public void habilitar(Long id) {
        Rol rol = rolRepository.buscarPorId(id).orElseThrow(() -> new RolNotFoundException(id));
        rol.habilitar();
        rolRepository.guardar(rol);
    }

    @Override
    public void deshabilitar(Long id) {
        Rol rol = rolRepository.buscarPorId(id)
                .orElseThrow(() -> new RolNotFoundException(id));
        rol.deshabilitar();
        rolRepository.guardar(rol);
    }*/

    @Override
    public void eliminar(Long id) {
        if (rolRepository.buscarPorId(id).isEmpty())
            throw new RolNotFoundException(id);
        rolRepository.eliminar(id);
    }

    private RolResponse toResponse(Rol rol) {
        return new RolResponse(
                rol.getRolId(),
                rol.getCodigo(),
                rol.getNombre()
        );
    }
}
