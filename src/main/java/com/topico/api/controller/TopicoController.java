package com.topico.api.controller;

import com.topico.api.domain.topico.Topico;
import com.topico.api.domain.topico.TopicoService;
import com.topico.api.dto.TopicoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Topico> crear(@RequestBody @Valid TopicoRequest request) {
        return ResponseEntity.ok(service.crear(request));
    }

    @GetMapping
    public List<Topico> listar() {
        return service.listar();
    }
}
