package com.example.livros.mapper;

import com.example.livros.model.dto.LivroDTO;
import com.example.livros.model.entity.Livro;

public class LivroMapper {
    public static LivroDTO toDTO(Livro livro) {
        if(livro == null) return null;
        return new LivroDTO(livro.getId(), livro.getAutor(), livro.getTitulo());
    }

    public static Livro toEntity(LivroDTO dto) {
        if(dto == null) return null;
        Livro livro = new Livro();
        livro.setId(dto.getId());
        livro.setAutor(dto.getAutor());
        livro.setTitulo(dto.getTitulo());
        return livro;
    }
}
