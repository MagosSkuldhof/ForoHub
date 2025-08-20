package com.tuusuario.forohub.controller;

import com.tuusuario.forohub.model.Topico;
import com.tuusuario.forohub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // Crear un nuevo tópico
    @PostMapping
    @Transactional
    public ResponseEntity<?> crearTopico(@Valid @RequestBody Topico topico) {
        // Validar duplicados
        Optional<Topico> existente = topicoRepository.findByTituloAndMensaje(topico.getTitulo(), topico.getMensaje());
        if (existente.isPresent()) {
            return ResponseEntity.badRequest().body("Error: Tópico duplicado");
        }

        Topico guardado = topicoRepository.save(topico);
        return ResponseEntity.ok(guardado);
    }

    // Listar todos los tópicos
    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }
}
