package com.example.Farmacia_grupo06.domain.exception.rol;

public class RolDuplicadoException extends RuntimeException {
    /*public RolDuplicadoException(String message) {
        super(message);
    }*/

    public RolDuplicadoException(String codigo) {
        super("Ya existe un rol con el código: " + codigo);
    }
}
