package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Genre;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreDAO {
    private final GenreRepository genreRepository;

    public GenreDAO(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        List<Genre> genreList = genreRepository.findAll();
        return genreList;
    }
}
