package com.bruna.webshop.dao;

import com.bruna.webshop.modules.GebruikerGegevens;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GebruikerGegevensDAO {
    private UserRepository gebruikerGegevensRepository;

    public GebruikerGegevensDAO(UserRepository gebruikerGegevensRepository) {
        this.gebruikerGegevensRepository = gebruikerGegevensRepository;
    }

    public List<GebruikerGegevens> getAllGebruikerGegevens() {
        List<GebruikerGegevens> GebruikerGegevens = gebruikerGegevensRepository.findAll();
        return GebruikerGegevens;
    }

    public GebruikerGegevens getByEmail(String email) {
        return gebruikerGegevensRepository.findByEmail(email);
    }
}
