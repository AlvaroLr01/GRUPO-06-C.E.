package com.example.Farmacia_grupo06.application.port.in;

import com.example.Farmacia_grupo06.application.dto.command.LoginCommand;
import com.example.Farmacia_grupo06.application.dto.response.LoginResponse;

public interface AuthUseCase {
    LoginResponse login(LoginCommand command);
}
