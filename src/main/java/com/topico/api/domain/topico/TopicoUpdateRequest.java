package com.topico.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record TopicoUpdateRequest(

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String status
) {}
