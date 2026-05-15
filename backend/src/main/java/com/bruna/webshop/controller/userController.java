package com.bruna.webshop.controller;

import com.bruna.webshop.dao.GebruikerGegevensDAO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.bruna.webshop.modules.GebruikerGegevens;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("gebruiker")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class userController {
    private GebruikerGegevensDAO gebruikerGegevensDAO;

    public userController(GebruikerGegevensDAO gebruikerGegevensDAO) {
        this.gebruikerGegevensDAO = gebruikerGegevensDAO;
    }

    @GetMapping("/me")
    public ResponseEntity<GebruikerGegevens> authenticatedGebruiker() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUser = (String) authentication.getPrincipal();

        GebruikerGegevens gebruikerGegevens = this.gebruikerGegevensDAO.getByEmail(currentUser);

        return ResponseEntity.ok(gebruikerGegevens);
    }

}

