package com.topico.api.domain.topico;

import com.topico.api.dto.TopicoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public Topico crear(TopicoRequest dto) {

        Topico topico = new Topico(
                null,
                dto.titulo(),
                dto.mensaje(),
                dto.status(),
                LocalDateTime.now()
        );

        return repository.save(topico);
    }

    public List<TopicoResponse> listar() {
        return repository.findAll()
                .stream()
                .map(TopicoResponse::new)
                .toList();
    }

    public Topico obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    public Topico actualizar(Long id, TopicoUpdateRequest dto) {
        Topico topico = obtener(id);
        topico.setTitulo(dto.titulo());
        topico.setMensaje(dto.mensaje());
        topico.setStatus(dto.status());
        return repository.save(topico);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
