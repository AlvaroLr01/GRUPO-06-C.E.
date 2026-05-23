package com.example.Farmacia_grupo06.infrastructure.persintence.repository.rol;

import com.example.Farmacia_grupo06.infrastructure.persintence.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RolJpaRepository extends JpaRepository<RolEntity, Long> {
    Optional<RolEntity> findByCodigo(String codigo);
    boolean existsByCodigo(String codigo);
    List<RolEntity> findByHabilitadoTrue();
}
