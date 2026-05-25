package com.example.Farmacia_grupo06.infrastructure.persintence.repository.medicamento;

import com.example.Farmacia_grupo06.infrastructure.persintence.entity.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoJpaRepository extends JpaRepository<MedicamentoEntity, Long> {
}
