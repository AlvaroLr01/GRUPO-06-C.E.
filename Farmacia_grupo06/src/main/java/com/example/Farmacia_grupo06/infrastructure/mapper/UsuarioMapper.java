package com.example.Farmacia_grupo06.infrastructure.mapper;

import com.example.Farmacia_grupo06.domain.model.Usuario;
import com.example.Farmacia_grupo06.infrastructure.persintence.entity.RolEntity;
import com.example.Farmacia_grupo06.infrastructure.persintence.entity.UsuarioEntity;

public class UsuarioMapper {

    private UsuarioMapper() {}

    public static Usuario toDomain(UsuarioEntity entity) {
        Usuario u = new Usuario();
        u.setUsuarioId(entity.getUsuarioId());
        u.setNombre(entity.getNombre());
        u.setApellido(entity.getApellido());
        u.setDni(entity.getDni());
        u.setUsuario(entity.getUsuario());
        u.setPassword(entity.getPassword());
        u.setTelefono(entity.getTelefono());
        u.setEstado(entity.getEstado());
        if (entity.getRolId() != null) {
            u.setRolId(RolMapper.toDomain(entity.getRolId()));
        }
        return u;

    }

    public static UsuarioEntity toEntity(Usuario usuario, RolEntity rolEntity) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setUsuarioId(usuario.getUsuarioId());
        entity.setNombre(usuario.getNombre());
        entity.setApellido(usuario.getApellido());
        entity.setDni(usuario.getDni());
        entity.setUsuario(usuario.getUsuario());
        entity.setPassword(usuario.getPassword());
        entity.setTelefono(usuario.getTelefono());
        entity.setEstado(usuario.getEstado());
        entity.setRolId(rolEntity);
        return entity;
    }
}
