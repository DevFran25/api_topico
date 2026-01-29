package com.topico.api.domain.topico;

import com.topico.api.dto.TopicoRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public Topico crear(TopicoRequest data) {
        Topico topico = new Topico(
                null,
                data.titulo(),
                data.mensaje(),
                data.status(),
                LocalDateTime.now()
        );
        return repository.save(topico);
    }

    public List<Topico> listar() {
        return repository.findAll();
    }
}
