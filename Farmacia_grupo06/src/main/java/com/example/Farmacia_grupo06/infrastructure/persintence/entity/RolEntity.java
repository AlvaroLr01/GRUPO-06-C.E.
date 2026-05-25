package com.example.Farmacia_grupo06.infrastructure.persintence.entity;

import com.example.Farmacia_grupo06.infrastructure.persintence.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "rol")
public class RolEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long rolId;
    private String codigo;
    private String nombre;

    public RolEntity(Long rolId, String codigo, String nombre) {
        this.rolId = rolId;
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
