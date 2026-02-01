package com.topico.api.infra;


import com.topico.api.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    // 6 horas
    private static final long EXPIRATION_TIME = 1000L * 60 * 60 * 6;

    public String generarToken(Usuario usuario) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        Instant exp = Instant.ofEpochMilli(System.currentTimeMillis() + EXPIRATION_TIME);

        return JWT.create()
                .withIssuer("api_topicos")
                .withSubject(usuario.getUsername())
                .withIssuedAt(Instant.now())
                .withExpiresAt(exp)
                .sign(algorithm);
    }

    public String getSubject(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.require(algorithm)
                .withIssuer("api_topicos")
                .build()
                .verify(token)
                .getSubject();
    }
}
