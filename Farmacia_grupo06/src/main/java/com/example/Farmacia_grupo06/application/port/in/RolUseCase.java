package com.example.Farmacia_grupo06.application.port.in;

import com.example.Farmacia_grupo06.application.dto.command.RolCommand;
import com.example.Farmacia_grupo06.interfaces.dto.rol.RolResponse;

import java.util.List;

public interface RolUseCase {

    RolResponse crear(RolCommand command);
    RolResponse actualizar(Long id, RolCommand command);
    RolResponse buscarPorId(Long id);
    List<RolResponse> listarTodos();
    void habilitar(Long id);
    void deshabilitar(Long id);
    void eliminar(Long id);
}
