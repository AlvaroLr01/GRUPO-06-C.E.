package com.example.Farmacia_grupo06.application.usecase;

import com.example.Farmacia_grupo06.domain.model.Medicamento;
import com.example.Farmacia_grupo06.domain.repository.MedicamentoRepository;

public class RegistrarMedicamento {

    private MedicamentoRepository repository;

    public RegistrarMedicamento(MedicamentoRepository repository) {
        this.repository = repository;
    }

    public void ejecutar(String nombre, double precio, int stock) {
        Medicamento medicamento = new Medicamento(null, nombre, precio, stock);
        medicamento.validar();
        repository.guardar(medicamento);
    }
}
