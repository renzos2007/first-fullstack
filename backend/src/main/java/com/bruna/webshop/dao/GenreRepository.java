package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
