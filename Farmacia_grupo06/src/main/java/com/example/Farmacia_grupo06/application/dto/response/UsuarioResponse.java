package com.example.Farmacia_grupo06.application.dto.response;

public record UsuarioResponse(Long    id,
                              String  nombres,
                              String  apellidos,
                              String  dni,
                              String  usuario,
                              String  telefono,
                              RolResponse rol  ) {
}
