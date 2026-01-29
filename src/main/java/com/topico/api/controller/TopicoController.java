package com.topico.api.controller;

import com.topico.api.domain.topico.Topico;
import com.topico.api.domain.topico.TopicoResponse;
import com.topico.api.domain.topico.TopicoService;
import com.topico.api.domain.topico.TopicoUpdateRequest;
import com.topico.api.dto.TopicoRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    // CREATE
    @PostMapping
    public ResponseEntity<Topico> crear(
            @RequestBody @Valid TopicoRequest dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.crear(dto));
    }

    // READ - todos
    @GetMapping
    public ResponseEntity<List<TopicoResponse>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // READ - por id
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(
            @PathVariable Long id,
            @RequestBody @Valid TopicoUpdateRequest dto) {

        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
