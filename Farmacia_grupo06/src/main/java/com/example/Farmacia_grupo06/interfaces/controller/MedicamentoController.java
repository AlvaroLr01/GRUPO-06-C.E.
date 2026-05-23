package com.example.Farmacia_grupo06.interfaces.controller;

import com.example.Farmacia_grupo06.application.usecase.RegistrarMedicamento;
import com.example.Farmacia_grupo06.interfaces.dto.medicamento.MedicamentoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {
    private final RegistrarMedicamento useCase;

    public MedicamentoController(RegistrarMedicamento useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody MedicamentoRequest request) {

        useCase.ejecutar(
                request.nombre,
                request.precio,
                request.stock
        );

        return "Medicamento registrado correctamente";
    }
}
