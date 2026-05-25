package com.example.Farmacia_grupo06.interfaces.dto.usuario;

public record UsuarioRequest(Long usuarioId,
                             String nombre,
                             String apellido,
                             String dni,
                             String usuario,
                             String password,
                             String telefono,
                             Boolean estado,
                             Long rolId) {
}
