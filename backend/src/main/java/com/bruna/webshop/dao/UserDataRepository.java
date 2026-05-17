package com.bruna.webshop.dao;

import com.bruna.webshop.modules.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
    UserData findByEmail(String email);
}
