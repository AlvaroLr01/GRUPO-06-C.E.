package com.example.Farmacia_grupo06.domain.exception.rol;

public class RolNotFoundException extends RuntimeException {
    public RolNotFoundException(String message) {
        super(message);
    }

    public RolNotFoundException(Long id) {
        super("Rol no encontrado con id: " + id);
    }
}
