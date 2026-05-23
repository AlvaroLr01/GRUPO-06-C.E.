package com.example.Farmacia_grupo06.interfaces.controller;

import com.example.Farmacia_grupo06.application.dto.command.ActualizarUsuarioCommand;
import com.example.Farmacia_grupo06.application.dto.command.CambiarPasswordCommand;
import com.example.Farmacia_grupo06.application.dto.command.UsuarioCommand;
import com.example.Farmacia_grupo06.application.dto.response.UsuarioResponse;
import com.example.Farmacia_grupo06.application.port.in.UsuarioUseCase;
import com.example.Farmacia_grupo06.interfaces.dto.usuario.ActualizarUsuarioRequest;
import com.example.Farmacia_grupo06.interfaces.dto.usuario.CambiarPasswordRequest;
import com.example.Farmacia_grupo06.interfaces.dto.usuario.UsuarioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioResponse> crear(@RequestBody UsuarioRequest request) {
        UsuarioCommand command = new UsuarioCommand(
                request.nombre(), request.apellido(), request.dni(),
                request.usuario(), request.password(),request.telefono(),
                request.estado(), request.rolId()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioUseCase.crear(command));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id, @RequestBody ActualizarUsuarioRequest request) {
        ActualizarUsuarioCommand command = new ActualizarUsuarioCommand(
                request.nombre(), request.apellido(),request.usuario(),
                request.dni(), request.telefono(), request.rolId()
        );
        return ResponseEntity.ok(usuarioUseCase.actualizar(id, command));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioUseCase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarTodos() {
        return ResponseEntity.ok(usuarioUseCase.listarTodos());
    }

    @PatchMapping("/{id}/cambiar-password")
    public ResponseEntity<Void> cambiarPassword(@PathVariable Long id, @RequestBody CambiarPasswordRequest request) {
        CambiarPasswordCommand command = new CambiarPasswordCommand(
                request.passwordActual(), request.passwordNuevo()
        );
        usuarioUseCase.cambiarPassword(id, command);
        return ResponseEntity.noContent().build();
    }

    /*@PatchMapping("/{id}/habilitar")
    public ResponseEntity<Void> habilitar(@PathVariable Long id) {
        usuarioUseCase.habilitar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deshabilitar")
    public ResponseEntity<Void> deshabilitar(@PathVariable Long id) {
        usuarioUseCase.deshabilitar(id);
        return ResponseEntity.noContent().build();
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
