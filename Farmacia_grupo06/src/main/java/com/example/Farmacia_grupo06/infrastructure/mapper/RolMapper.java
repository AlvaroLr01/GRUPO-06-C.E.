package com.example.Farmacia_grupo06.infrastructure.mapper;

import com.example.Farmacia_grupo06.domain.model.Rol;
import com.example.Farmacia_grupo06.infrastructure.persintence.entity.RolEntity;

public class RolMapper {

    private RolMapper() {}

    public static Rol toDomain(RolEntity entity) {
        Rol rol = new Rol();
        rol.setRolId(entity.getRolId());
        rol.setNombre(entity.getNombre());
        rol.setCodigo(entity.getCodigo());
        rol.setHabilitado(entity.getHabilitado());
        return rol;
    }

    public static RolEntity toEntity(Rol rol) {
        RolEntity entity = new RolEntity();
        entity.setRolId(rol.getRolId());
        entity.setCodigo(rol.getCodigo());
        entity.setNombre(rol.getNombre());
        entity.setHabilitado(rol.getHabilitado());
        return entity;
    }
}
