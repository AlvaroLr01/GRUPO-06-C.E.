package com.example.Farmacia_grupo06.domain.repository;

import com.example.Farmacia_grupo06.domain.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolRepository {

    Optional<Rol> buscarPorId(Long id);
    Optional<Rol> buscarPorCodigo(String codigo);
    boolean existePorCodigo(String codigo);
    List<Rol> listarTodos();
    List<Rol> listarHabilitados();
    Rol guardar(Rol rol);
    void eliminar(Long id);
}
