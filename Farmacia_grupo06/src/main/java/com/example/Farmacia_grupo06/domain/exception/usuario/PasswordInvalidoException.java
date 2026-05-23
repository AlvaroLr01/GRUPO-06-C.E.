package com.example.Farmacia_grupo06.domain.exception.usuario;

public class PasswordInvalidoException extends RuntimeException {
    public PasswordInvalidoException(String message) {
        super(message);
    }

    public PasswordInvalidoException() {
        super("La contraseña actual es incorrecta");
    }
}
