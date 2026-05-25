package com.example.Farmacia_grupo06.application.dto.response;

public record LoginResponse(String  token,
                            String  tipo,        // "Bearer"
                            Long    idUsuario,
                            String  username,
                            String  nombres,
                            String  apellidos,
                            String  rol) {
}
