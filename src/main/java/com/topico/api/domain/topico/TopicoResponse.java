package com.topico.api.domain.topico;

import java.time.LocalDateTime;

public record TopicoResponse(
        Long id,
        String titulo,
        String mensaje,
        String status,
        LocalDateTime fechaCreacion
) {
    public TopicoResponse(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getFechaCreacion()
        );
    }
}
