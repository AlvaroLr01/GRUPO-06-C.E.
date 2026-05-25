package com.example.Farmacia_grupo06.application.dto.command;

public record UsuarioCommand(String nombres,
                             String apellidos,
                             String dni,
                             String usuario,
                             String password,
                             String telefono,
                             Boolean estado,
                             Long   idRol) {
}
