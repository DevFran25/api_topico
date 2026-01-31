package com.topico.api.infra;


import com.topico.api.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String secret;

    public String generarToken(Usuario usuario) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("API Topicos")
                .withSubject(usuario.getUsername())
                .withExpiresAt(expiracion())
                .sign(algorithm);
    }

    public String getSubject(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.require(algorithm)
                .withIssuer("API Topicos")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant expiracion() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.UTC);
    }
}
