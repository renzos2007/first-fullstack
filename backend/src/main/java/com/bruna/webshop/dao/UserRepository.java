package com.bruna.webshop.dao;

import com.bruna.webshop.modules.GebruikerGegevens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<GebruikerGegevens, Long> {
    GebruikerGegevens findByEmail(String email);
}
