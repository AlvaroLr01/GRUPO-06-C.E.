package com.example.Farmacia_grupo06.application.dto.command;

public record ActualizarUsuarioCommand(String nombres,
                                       String apellidos,
                                       String usuario,
                                       String dni,
                                       String telefono,
                                       Long   idRol) {
}
