package com.example.Farmacia_grupo06.interfaces.controller;

import com.example.Farmacia_grupo06.application.dto.command.RolCommand;
import com.example.Farmacia_grupo06.application.port.in.RolUseCase;
import com.example.Farmacia_grupo06.interfaces.dto.rol.RolRequest;
import com.example.Farmacia_grupo06.interfaces.dto.rol.RolResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolController {
    private final RolUseCase rolUseCase;

    public RolController(RolUseCase rolUseCase) {
        this.rolUseCase = rolUseCase;
    }

    @PostMapping("/save")
    public ResponseEntity<RolResponse> crear(@RequestBody RolRequest request) {
        RolCommand command = new RolCommand(request.codigo(), request.nombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(rolUseCase.crear(command));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RolResponse> actualizar(@PathVariable Long id, @RequestBody RolRequest request) {
        RolCommand command = new RolCommand(request.codigo(), request.nombre());
        return ResponseEntity.ok(rolUseCase.actualizar(id, command));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RolResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(rolUseCase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<RolResponse>> listarTodos() {
        return ResponseEntity.ok(rolUseCase.listarTodos());
    }

    @PatchMapping("/{id}/habilitar")
    public ResponseEntity<Void> habilitar(@PathVariable Long id) {
        rolUseCase.habilitar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deshabilitar")
    public ResponseEntity<Void> deshabilitar(@PathVariable Long id) {
        rolUseCase.deshabilitar(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        rolUseCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
