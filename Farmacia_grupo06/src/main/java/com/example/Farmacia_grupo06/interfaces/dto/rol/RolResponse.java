package com.example.Farmacia_grupo06.interfaces.dto.rol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class RolResponse implements Serializable {
    private Long rolId;
    private String codigo;
    private String nombre;
    private Boolean habilitado;

    public RolResponse(Long rolId, String codigo, String nombre, Boolean habilitado) {
        this.rolId = rolId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.habilitado = habilitado;
    }
}
