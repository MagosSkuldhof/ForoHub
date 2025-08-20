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

    // Obtener un tópico específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerTopicoPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(topico -> ResponseEntity.ok(topico))
                .orElseGet(() -> ResponseEntity.status(404).body("Error: Tópico no encontrado"));
    }

    // Actualizar un tópico existente
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> actualizarTopico(
            @PathVariable Long id,
            @Valid @RequestBody Topico topicoActualizado) {

        Optional<Topico> topicoExistente = topicoRepository.findById(id);

        if (!topicoExistente.isPresent()) {
            return ResponseEntity.status(404).body("Error: Tópico no encontrado");
        }

        // Verificar duplicados (titulo + mensaje) con otros tópicos
        Optional<Topico> duplicado = topicoRepository
                .findByTituloAndMensaje(topicoActualizado.getTitulo(), topicoActualizado.getMensaje());

        if (duplicado.isPresent() && !duplicado.get().getId().equals(id)) {
            return ResponseEntity.badRequest().body("Error: Tópico duplicado");
        }

        Topico topico = topicoExistente.get();
        topico.setTitulo(topicoActualizado.getTitulo());
        topico.setMensaje(topicoActualizado.getMensaje());
        topico.setAutor(topicoActualizado.getAutor());
        topico.setCurso(topicoActualizado.getCurso());
        topico.setEstado(topicoActualizado.getEstado());

        Topico guardado = topicoRepository.save(topic


                // Listar todos los tópicos
    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll(); // Devuelve todos los campos de cada tópico
    }

}
