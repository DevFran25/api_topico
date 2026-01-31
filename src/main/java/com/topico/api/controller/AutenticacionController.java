package com.topico.api.controller;


import com.topico.api.domain.usuario.Usuario;
import com.topico.api.infra.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest dto) {

        Authentication auth = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.username(), dto.password())
        );

        String token = tokenService.generarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }
}
