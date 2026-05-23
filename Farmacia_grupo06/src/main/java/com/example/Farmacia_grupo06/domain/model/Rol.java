package com.example.Farmacia_grupo06.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Rol {

    private Long rolId;
    private String codigo;
    private String nombre;
    private Boolean habilitado;

    public Rol(Long rolId, String codigo, String nombre, Boolean habilitado) {
        this.rolId = rolId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.habilitado = habilitado;
    }

    public void habilitar()    {
        this.habilitado = true;
    }

    public void deshabilitar() {
        this.habilitado = false;
    }
}
