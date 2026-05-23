package com.example.Farmacia_grupo06.domain.exception.usuario;

public class UsuarioDuplicadoException extends RuntimeException {
    public UsuarioDuplicadoException(String message) {
        super(message);
    }

    public UsuarioDuplicadoException(String campo, String valor) {
        super("Ya existe un usuario con " + campo + ": " + valor);
    }

}
