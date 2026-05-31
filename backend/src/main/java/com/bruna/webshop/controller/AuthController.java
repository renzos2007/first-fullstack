package com.bruna.webshop.controller;


import com.bruna.webshop.config.JWTUtil;
import com.bruna.webshop.repositories.RoleRepository;
import com.bruna.webshop.repositories.UserDataRepository;
import com.bruna.webshop.dto.AuthenticationDTO;
import com.bruna.webshop.dto.LoginResponse;
import com.bruna.webshop.modules.ERole;
import com.bruna.webshop.modules.UserData;
import com.bruna.webshop.modules.Role;
import com.bruna.webshop.services.CredentialValidator;
import com.bruna.webshop.services.UserDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {
    private final UserDataService userDataService;

    public AuthController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody AuthenticationDTO authenticationDTO) {
        return userDataService.RegisterUser(authenticationDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return userDataService.loginUser(authenticationDTO);
    }

}
