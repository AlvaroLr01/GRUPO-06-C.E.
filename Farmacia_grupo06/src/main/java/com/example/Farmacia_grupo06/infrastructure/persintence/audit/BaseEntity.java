package com.example.Farmacia_grupo06.infrastructure.persintence.audit;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name = "habilitado")
    private Boolean habilitado;
    @Column(name = "creado_por", length = 100)
    private String creadoPor;
    @Column(name = "modificado_por")
    private String modificadoPor;
    @Column(name = "creado")
    private LocalDateTime creado;
    @Column(name = "modificado", length = 100)
    private LocalDateTime modificado;
}
