package com.bruna.webshop.dao;

import com.bruna.webshop.modules.UserData;
import com.bruna.webshop.repositories.UserDataRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataDAO {
    private final UserDataRepository userDataRepository;

    public UserDataDAO(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public UserData save(UserData userData) {
        return userDataRepository.save(userData);
    }

    public UserData getUserDataByEmail(String email) {
        return userDataRepository.findByEmail(email);
    }
}
