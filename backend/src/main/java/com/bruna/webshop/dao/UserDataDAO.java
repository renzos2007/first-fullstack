package com.bruna.webshop.dao;

import com.bruna.webshop.modules.UserData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataDAO {
    private final UserDataRepository userDataRepository;

    public UserDataDAO(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public List<UserData> getAllUserData() {
        List<UserData> UserDataList = userDataRepository.findAll();
        return UserDataList;
    }

    public UserData getUserDataByEmail(String email) {
        return userDataRepository.findByEmail(email);
    }
}
