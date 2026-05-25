package com.example.Farmacia_grupo06.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Usuario {

    private Long usuarioId;
    private String nombre;
    private String apellido;
    private String dni;
    private String usuario;
    private String password;
    private String telefono;
    private Boolean estado;
    private Rol rolId;

    public Usuario(Long usuarioId, String nombre, String apellido, String dni, String usuario, String password, String telefono, Boolean estado, Rol rolId) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.usuario = usuario;
        this.password = password;
        this.telefono = telefono;
        this.estado = estado;
        this.rolId = rolId;
    }

    public void actualizarDatos(String nombre, String apellido, String dni, String telefono, Rol rolId) {
        this.nombre   = nombre;
        this.apellido = apellido;
        this.dni      = dni;
        this.telefono = telefono;
        this.rolId    = rolId;
    }

    public void cambiarPassword(String nuevoPasswordHash) {
        this.password = nuevoPasswordHash;
    }
}
