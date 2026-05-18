package com.bruna.webshop.controller;

import com.bruna.webshop.dao.UserDataDAO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.bruna.webshop.modules.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class userController {
    private UserDataDAO userDataDAO;

    public userController(UserDataDAO userDataDAO) {
        this.userDataDAO = userDataDAO;
    }

    @GetMapping("/me")
    public ResponseEntity<UserData> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserEmail = (String) authentication.getPrincipal();

        UserData userData = this.userDataDAO.getUserDataByEmail(currentUserEmail);

        return ResponseEntity.ok(userData);
    }

}

