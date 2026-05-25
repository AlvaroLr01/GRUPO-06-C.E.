package com.example.Farmacia_grupo06.interfaces.dto.usuario;

public record ActualizarUsuarioRequest(String nombre,
                                       String apellido,
                                       String usuario,
                                       String dni,
                                       String telefono,
                                       Long rolId) {
}
