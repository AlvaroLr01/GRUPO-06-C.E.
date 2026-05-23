package com.example.Farmacia_grupo06.application.dto.command;

public record CambiarPasswordCommand(String passwordActual,
                                     String passwordNuevo) {
}
