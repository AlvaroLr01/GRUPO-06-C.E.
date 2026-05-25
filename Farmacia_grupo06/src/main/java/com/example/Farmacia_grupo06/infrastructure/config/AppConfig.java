package com.example.Farmacia_grupo06.infrastructure.config;

import com.example.Farmacia_grupo06.application.port.in.AuthUseCase;
import com.example.Farmacia_grupo06.application.port.in.RolUseCase;
import com.example.Farmacia_grupo06.application.port.in.UsuarioUseCase;
import com.example.Farmacia_grupo06.application.usecase.AuthService;
import com.example.Farmacia_grupo06.application.usecase.RegistrarMedicamento;
import com.example.Farmacia_grupo06.application.usecase.RolService;
import com.example.Farmacia_grupo06.application.usecase.UsuarioService;
import com.example.Farmacia_grupo06.domain.repository.MedicamentoRepository;
import com.example.Farmacia_grupo06.domain.repository.RolRepository;
import com.example.Farmacia_grupo06.domain.repository.UsuarioRepository;
import com.example.Farmacia_grupo06.infrastructure.security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public RegistrarMedicamento registrarMedicamentoUseCase(MedicamentoRepository repository) {
        return new RegistrarMedicamento(repository);
    }

    @Bean
    public RolUseCase rolUseCase(RolRepository rolRepository) {
        return new RolService(rolRepository);
    }

    @Bean
    public UsuarioUseCase usuarioUseCase(UsuarioRepository usuarioRepository,
                                         RolRepository rolRepository,
                                         PasswordEncoder passwordEncoder) {
        return new UsuarioService(usuarioRepository, rolRepository, passwordEncoder);
    }

    @Bean
    public AuthUseCase authUseCase(UsuarioRepository usuarioRepository,
                                   PasswordEncoder passwordEncoder,
                                   JwtTokenProvider jwtTokenProvider) {
        return new AuthService(usuarioRepository, passwordEncoder, jwtTokenProvider);
    }
}
