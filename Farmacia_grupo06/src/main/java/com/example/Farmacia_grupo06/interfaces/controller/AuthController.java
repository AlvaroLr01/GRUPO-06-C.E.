package com.example.Farmacia_grupo06.interfaces.controller;

import com.example.Farmacia_grupo06.application.dto.command.LoginCommand;
import com.example.Farmacia_grupo06.application.dto.response.LoginResponse;
import com.example.Farmacia_grupo06.application.port.in.AuthUseCase;
import com.example.Farmacia_grupo06.interfaces.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthUseCase authUseCase;

    public AuthController(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginCommand command = new LoginCommand(
                request.username(),
                request.password()
        );
        return ResponseEntity.ok(authUseCase.login(command));
    }
}
