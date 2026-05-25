package com.example.Farmacia_grupo06.application.usecase;

import com.example.Farmacia_grupo06.application.dto.command.LoginCommand;
import com.example.Farmacia_grupo06.application.dto.response.LoginResponse;
import com.example.Farmacia_grupo06.application.port.in.AuthUseCase;
import com.example.Farmacia_grupo06.domain.exception.login.CredencialesInvalidasException;
import com.example.Farmacia_grupo06.domain.model.Usuario;
import com.example.Farmacia_grupo06.domain.repository.UsuarioRepository;
import com.example.Farmacia_grupo06.infrastructure.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthService implements AuthUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider  jwtTokenProvider;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder   = passwordEncoder;
        this.jwtTokenProvider  = jwtTokenProvider;
    }

    @Override
    public LoginResponse login(LoginCommand command) {
        Usuario usuario = usuarioRepository.buscarPorUsuario(command.username()).orElseThrow(() -> {
            System.out.println("Usuario no encontrado");
            return new CredencialesInvalidasException();
        });

        boolean coincide = passwordEncoder.matches(command.password(), usuario.getPassword());

        if (!coincide)
            throw new CredencialesInvalidasException();

        String token = jwtTokenProvider.generarToken(usuario);

        return new LoginResponse(
                token,
                "Bearer",
                usuario.getUsuarioId(),
                usuario.getUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getRolId().getNombre()
        );
    }
}
