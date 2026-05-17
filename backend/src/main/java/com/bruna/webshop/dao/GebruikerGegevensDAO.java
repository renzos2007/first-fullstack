package com.bruna.webshop.dao;

import com.bruna.webshop.modules.UserData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GebruikerGegevensDAO {
    private UserDataRepository gebruikerGegevensRepository;

    public GebruikerGegevensDAO(UserDataRepository gebruikerGegevensRepository) {
        this.gebruikerGegevensRepository = gebruikerGegevensRepository;
    }

    public List<UserData> getAllGebruikerGegevens() {
        List<UserData> UserData = gebruikerGegevensRepository.findAll();
        return UserData;
    }

    public UserData getByEmail(String email) {
        return gebruikerGegevensRepository.findByEmail(email);
    }
}
