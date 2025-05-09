package com.example.livros.controller;

import com.example.livros.model.dto.LivroDTO;
import com.example.livros.service.LivroService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public ResponseEntity<List<LivroDTO>> listarLivros() {
        return ResponseEntity.ok(livroService.listarTodos());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<LivroDTO> adicionarLivro(@RequestBody LivroDTO livroDTO) {
        LivroDTO salvo = livroService.adicionar(livroDTO);
        return ResponseEntity.status(201).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LivroDTO> removerLivro(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.remover(id));
    }
}
