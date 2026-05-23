package com.example.Farmacia_grupo06.application.port.in;

import com.example.Farmacia_grupo06.application.dto.command.ActualizarUsuarioCommand;
import com.example.Farmacia_grupo06.application.dto.command.CambiarPasswordCommand;
import com.example.Farmacia_grupo06.application.dto.command.UsuarioCommand;
import com.example.Farmacia_grupo06.application.dto.response.UsuarioResponse;

import java.util.List;

public interface UsuarioUseCase {
    UsuarioResponse crear(UsuarioCommand command);
    UsuarioResponse actualizar(Long id, ActualizarUsuarioCommand command);
    UsuarioResponse buscarPorId(Long id);
    List<UsuarioResponse> listarTodos();
    void cambiarPassword(Long id, CambiarPasswordCommand command);
    void eliminar(Long id);

    /*void habilitar(Long id);
    void deshabilitar(Long id);*/
}
