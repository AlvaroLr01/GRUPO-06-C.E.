package com.example.Farmacia_grupo06.infrastructure.persintence.entity;

import com.example.Farmacia_grupo06.infrastructure.persintence.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long usuarioId;
    private String nombre;
    private String apellido;
    private String dni;
    private String usuario;
    private String password;
    private String telefono;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private RolEntity rolId;
}
