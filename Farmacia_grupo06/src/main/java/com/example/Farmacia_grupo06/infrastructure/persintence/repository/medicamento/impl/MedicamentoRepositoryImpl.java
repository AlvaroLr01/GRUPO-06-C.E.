package com.example.Farmacia_grupo06.infrastructure.persintence.repository.medicamento.impl;

import com.example.Farmacia_grupo06.domain.model.Medicamento;
import com.example.Farmacia_grupo06.domain.repository.MedicamentoRepository;
import com.example.Farmacia_grupo06.infrastructure.persintence.entity.MedicamentoEntity;
import com.example.Farmacia_grupo06.infrastructure.persintence.repository.medicamento.MedicamentoJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MedicamentoRepositoryImpl implements MedicamentoRepository {

    private final MedicamentoJpaRepository jpaRepository;

    public MedicamentoRepositoryImpl(MedicamentoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void guardar(Medicamento medicamento) {

        MedicamentoEntity entity = new MedicamentoEntity();
        entity.setNombre(medicamento.getNombre());
        entity.setPrecio(medicamento.getPrecio());
        entity.setStock(medicamento.getStock());

        jpaRepository.save(entity);
    }
}
