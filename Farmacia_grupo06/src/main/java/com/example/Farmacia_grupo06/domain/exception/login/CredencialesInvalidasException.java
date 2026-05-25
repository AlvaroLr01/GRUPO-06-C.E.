package com.example.Farmacia_grupo06.domain.exception.login;

public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException(String message) {
        super(message);
    }

    public CredencialesInvalidasException() {
        // Mensaje genérico a propósito: no revelar si el username existe o no
        super("Credenciales incorrectas");
    }
}
