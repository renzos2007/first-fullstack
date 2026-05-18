package com.bruna.webshop.controller;


import com.bruna.webshop.config.JWTUtil;
import com.bruna.webshop.dao.RoleRepository;
import com.bruna.webshop.dao.UserDataRepository;
import com.bruna.webshop.dto.AuthenticationDTO;
import com.bruna.webshop.dto.LoginResponse;
import com.bruna.webshop.modules.ERole;
import com.bruna.webshop.modules.UserData;
import com.bruna.webshop.modules.Role;
import com.bruna.webshop.services.CredentialValidator;
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

    private final UserDataRepository userDataRepository;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private CredentialValidator validator;
    private RoleRepository roleRepository;

    public AuthController(UserDataRepository userDataRepository, JWTUtil jwtUtil, AuthenticationManager authManager,
                          PasswordEncoder passwordEncoder, CredentialValidator validator, RoleRepository roleRepository) {
        this.userDataRepository = userDataRepository;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
        this.validator = validator;
        this.roleRepository = roleRepository;
    }

//    @PostMapping("/register")
//    public ResponseEntity<LoginResponse> register(@RequestBody AuthenticationDTO authenticationDTO) {
//        if (!validator.isValidEmail(authenticationDTO.email)) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "No valid email provided"
//            );
//        }
//
//        if (!validator.isValidPassword(authenticationDTO.password)) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "No valid password provided"
//            );
//        }
//
//        GebruikerGegevens customUser = userRepository.findByEmail(authenticationDTO.email);
//
//        if (customUser != null){
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Can not register with this email"
//            );
//        }
//        String encodedPassword = passwordEncoder.encode(authenticationDTO.password);
//
//        GebruikerGegevens registerdCustomUser = new GebruikerGegevens(authenticationDTO.userName, encodedPassword, authenticationDTO.email, authenticationDTO.city, authenticationDTO.postalCode, authenticationDTO.streetName, authenticationDTO.houseNumber);
//
//        Set<Role> strRoles = authenticationDTO.role;
//        Set<Role> roles = new HashSet<>();
//
//        if (strRoles == null || strRoles.isEmpty()) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//            roles.add(userRole);
//        } else {
//            strRoles.forEach(role -> {
//                if (role.equals("admin")) {
//                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(adminRole);
//                } else {
//                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//                    roles.add(userRole);
//                }
//            });
//        }
//        userRepository.saveOrder(registerdCustomUser);
//
//        registerdCustomUser.setRoles(roles);
//
//        String token = jwtUtil.generateToken(registerdCustomUser.getEmail());
//        LoginResponse loginResponse = new LoginResponse(registerdCustomUser.getEmail(), token);
//        return ResponseEntity.ok(loginResponse);
//    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody AuthenticationDTO authenticationDTO) {
        if (!validator.isValidEmail(authenticationDTO.email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No valid email provided");
        }

        if (!validator.isValidPassword(authenticationDTO.password)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No valid password provided");
        }

        if (userDataRepository.findByEmail(authenticationDTO.email) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email is already in use");
        }

        String encodedPassword = passwordEncoder.encode(authenticationDTO.password);
        UserData registeredUser  = new UserData(authenticationDTO.userName, encodedPassword, authenticationDTO.email, authenticationDTO.city, authenticationDTO.postalCode, authenticationDTO.streetName, authenticationDTO.houseNumber);

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        registeredUser .setRoles(roles);
        userDataRepository.save(registeredUser);

        String token = jwtUtil.generateToken(registeredUser .getEmail());
        LoginResponse loginResponse = new LoginResponse(registeredUser .getEmail(), token);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthenticationDTO body) {
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.email, body.password);

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.email);

            UserData customUser = userDataRepository.findByEmail(body.email);
            LoginResponse loginResponse = new LoginResponse(customUser.getEmail(), token);


            return ResponseEntity.ok(loginResponse);

        } catch (AuthenticationException authExc) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "No valid credentials"
            );
        }
    }

}
