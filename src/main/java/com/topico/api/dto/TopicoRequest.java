package com.topico.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TopicoRequest(

        @NotBlank(message = "El título es obligatorio")
        @Size(max = 150)
        String titulo,

        @NotBlank(message = "El mensaje es obligatorio")
        String mensaje,

        @NotBlank(message = "El status es obligatorio")
        String status
) {}
