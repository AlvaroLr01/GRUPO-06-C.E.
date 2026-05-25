package com.example.Farmacia_grupo06.domain.repository;

import com.example.Farmacia_grupo06.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(Long id);
    Optional<Usuario> buscarPorUsuario(String usuario);
    Optional<Usuario> buscarPorDni(String dni);
    boolean existePorUsuario(String usuario);
    boolean existePorDni(String dni);
    List<Usuario> listarTodos();
    List<Usuario> listarHabilitados();
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
}
