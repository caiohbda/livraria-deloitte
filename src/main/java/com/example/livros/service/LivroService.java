package com.example.livros.service;

import com.example.livros.model.dto.LivroDTO;

import java.util.List;

public interface LivroService {
    List<LivroDTO> listarTodos();
    LivroDTO adicionar(LivroDTO livroDTO);
    LivroDTO remover(Long id);
}
