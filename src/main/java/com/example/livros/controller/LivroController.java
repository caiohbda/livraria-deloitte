package com.example.livros.controller;

import com.example.livros.model.Livro;
import com.example.livros.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController {
    private LivroRepository livroRepository;

    @GetMapping("/listar")
    public List<Livro> listarLivros() {
        try {
            return livroRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao listar livros");
        }
    }

    @PostMapping("/adicionar")
    public Livro adicionarLivro(@RequestBody Livro livro) {
       return livroRepository.save(livro);
    }

    @DeleteMapping("/{id}")
    public void removerLivro(@PathVariable Long id) {
        if (!livroRepository.existsById(id)) {
            throw new Error("Livro não encontrado para remoção.");
        }
        livroRepository.deleteById(id);
    }
}
