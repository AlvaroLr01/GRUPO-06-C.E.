package com.example.Farmacia_grupo06.domain.exception.login;

public class UsuarioDeshabilitadoException extends RuntimeException {
    public UsuarioDeshabilitadoException(String message) {
        super(message);
    }

    public UsuarioDeshabilitadoException() {
        super("El usuario se encuentra deshabilitado");
    }
}
