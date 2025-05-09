package com.example.livros.service.impl;

import com.example.livros.exception.NotFoundException;
import com.example.livros.mapper.LivroMapper;
import com.example.livros.model.dto.LivroDTO;
import com.example.livros.model.entity.Livro;
import com.example.livros.repository.LivroRepository;
import com.example.livros.service.LivroService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public List<LivroDTO> listarTodos() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream()
                .map(LivroMapper::toDTO)
                .toList();
    }

    @Override
    public LivroDTO adicionar(LivroDTO livroDTO) {
        Livro livro = LivroMapper.toEntity(livroDTO);
        Livro salvo = livroRepository.save(livro);
        return LivroMapper.toDTO(salvo);
    }

    @Override
    public LivroDTO remover(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Livro não encontrado para remoção."));
        livroRepository.deleteById(id);
        return LivroMapper.toDTO(livro);
    }
}
