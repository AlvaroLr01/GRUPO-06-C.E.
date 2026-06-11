package com.example.Farmacia_grupo06.infrastructure.security.impl;

import com.example.Farmacia_grupo06.infrastructure.persintence.entity.UsuarioEntity;
import com.example.Farmacia_grupo06.infrastructure.persintence.repository.usuario.UsuarioJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsuarioJpaRepository usuarioJpaRepository;

    public UserDetailsServiceImpl(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        UsuarioEntity entity = usuarioJpaRepository.findByUsuario(usuario).orElseThrow(() ->
                new UsernameNotFoundException("Usuario no encontrado: " + usuario));

        return org.springframework.security.core.userdetails.User
                .withUsername(entity.getUsuario())
                .password(entity.getPassword())
                .authorities("ROLE_" + entity.getRolId().getCodigo())
                .build();
    }
}
