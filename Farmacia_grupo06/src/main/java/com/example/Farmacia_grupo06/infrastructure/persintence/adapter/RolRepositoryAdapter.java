package com.example.Farmacia_grupo06.infrastructure.persintence.adapter;

import com.example.Farmacia_grupo06.domain.model.Rol;
import com.example.Farmacia_grupo06.domain.repository.RolRepository;
import com.example.Farmacia_grupo06.infrastructure.mapper.RolMapper;
import com.example.Farmacia_grupo06.infrastructure.persintence.entity.RolEntity;
import com.example.Farmacia_grupo06.infrastructure.persintence.repository.rol.RolJpaRepository;
import com.example.Farmacia_grupo06.interfaces.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RolRepositoryAdapter implements RolRepository {

    private final RolJpaRepository jpaRepository;

    public RolRepositoryAdapter(RolJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Rol> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(RolMapper::toDomain);
    }

    @Override
    public Optional<Rol> buscarPorCodigo(String codigo) {
        return jpaRepository.findByCodigo(codigo).map(RolMapper::toDomain);
    }

    @Override
    public boolean existePorCodigo(String codigo) {
        return jpaRepository.existsByCodigo(codigo);
    }

    @Override
    public List<Rol> listarTodos() {
        return jpaRepository.findAll()
                .stream()
                .map(RolMapper::toDomain)
                .toList();
    }

    @Override
    public List<Rol> listarHabilitados() {
        return jpaRepository.findByHabilitadoTrue()
                .stream()
                .map(RolMapper::toDomain)
                .toList();
    }

    @Override
    public Rol guardar(Rol rol) {
        RolEntity entity;

        if (rol.getRolId() != null) {
            entity = jpaRepository.findById(rol.getRolId()).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            entity.setCodigo(rol.getCodigo());
            entity.setNombre(rol.getNombre());
            entity.setHabilitado(rol.getHabilitado());
            entity.setModificado(DateUtil.getCurrentLocalDateTime());

        } else {
            entity = RolMapper.toEntity(rol);
            entity.setCreado(DateUtil.getCurrentLocalDateTime());
        }

        return RolMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }
}
