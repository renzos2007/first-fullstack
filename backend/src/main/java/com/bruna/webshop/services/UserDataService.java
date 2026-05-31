package com.bruna.webshop.services;

import com.bruna.webshop.config.JWTUtil;
import com.bruna.webshop.dao.RoleDAO;
import com.bruna.webshop.dao.UserDataDAO;
import com.bruna.webshop.dto.AuthenticationDTO;
import com.bruna.webshop.dto.LoginResponse;
import com.bruna.webshop.modules.ERole;
import com.bruna.webshop.modules.Role;
import com.bruna.webshop.modules.UserData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDataService {
    private final UserDataDAO userDataDAO;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final CredentialValidator validator;
    private final RoleDAO roleDAO;

    public UserDataService(UserDataDAO userDataDAO, JWTUtil jwtUtil, AuthenticationManager authManager, PasswordEncoder passwordEncoder, CredentialValidator validator, RoleDAO roleDAO) {
        this.userDataDAO = userDataDAO;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
        this.validator = validator;
        this.roleDAO = roleDAO;
    }

    public ResponseEntity<LoginResponse> RegisterUser(AuthenticationDTO authenticationDTO) {
        validateEmail(authenticationDTO.email);
        validatePassword(authenticationDTO.password);
        validateUniqueEmail(authenticationDTO.email);


        String encodedPassword = passwordEncoder.encode(authenticationDTO.password);
        UserData registeredUser  = new UserData(authenticationDTO.userName, encodedPassword, authenticationDTO.email, authenticationDTO.city, authenticationDTO.postalCode, authenticationDTO.streetName, authenticationDTO.houseNumber);

        Set<Role> roles = new HashSet<>();
        Role userRole = roleDAO.findByName(ERole.ROLE_USER);
        roles.add(userRole);

        registeredUser .setRoles(roles);
        userDataDAO.save(registeredUser);

        String token = jwtUtil.generateToken(registeredUser .getEmail());
        LoginResponse loginResponse = new LoginResponse(registeredUser .getEmail(), token);
        return ResponseEntity.ok(loginResponse);
    }

    public UserData getUserByToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = (String) authentication.getPrincipal();

        UserData userData = userDataDAO.getUserDataByEmail(userEmail);

        return userData;
    }

    public ResponseEntity<LoginResponse> loginUser(AuthenticationDTO body) {
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.email, body.password);

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.email);

            UserData customUser = userDataDAO.getUserDataByEmail(body.email);
            LoginResponse loginResponse = new LoginResponse(customUser.getEmail(), token);


            return ResponseEntity.ok(loginResponse);

        } catch (AuthenticationException authExc) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "No valid credentials"
            );
        }
    }

    private void validateEmail(String email) {
        if (!validator.isValidEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No valid email provided");
        }
    }

    private void validatePassword(String password) {
        if (!validator.isValidPassword(password)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No valid password provided");
        }
    }

    private void validateUniqueEmail(String email) {
        if (userDataDAO.getUserDataByEmail(email) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email is already in use");
        }
    }
}
