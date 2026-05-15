package com.bruna.webshop.services;


import com.bruna.webshop.dao.UserRepository;
import com.bruna.webshop.modules.GebruikerGegevens;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        GebruikerGegevens customUser = userRepository.findByEmail(email);

        return new User(
                email,
                customUser.getWachtwoord(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
