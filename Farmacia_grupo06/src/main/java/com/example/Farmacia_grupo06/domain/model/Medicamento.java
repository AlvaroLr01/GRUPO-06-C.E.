package com.example.Farmacia_grupo06.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Medicamento {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;

    public Medicamento(Long id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void validar() {
        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("Nombre inválido");
        }
        if (precio <= 0) {
            throw new RuntimeException("Precio inválido");
        }
        if (stock < 0) {
            throw new RuntimeException("Stock inválido");
        }
    }
}
