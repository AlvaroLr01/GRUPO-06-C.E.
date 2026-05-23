package com.example.Farmacia_grupo06.infrastructure.persintence.repository.usuario;

import com.example.Farmacia_grupo06.infrastructure.persintence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsuario(String usuario);
    Optional<UsuarioEntity> findByDni(String dni);
    boolean existsByUsuario(String usuario);
    boolean existsByDni(String dni);
    List<UsuarioEntity> findByHabilitadoTrue();
}
