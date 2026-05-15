package com.bruna.webshop.dto;

import com.bruna.webshop.modules.Role;

import java.util.Set;

public class AuthenticationDTO {
    public String email;
    public String gebruikersnaam;
    public String wachtwoord;
    public String woonplaats;
    public String postcode;
    public String straatnaam;
    public String huisnummer;
    public Set<Role> role;


    public AuthenticationDTO(String email, String gebruikersnaam, String wachtwoord, String woonplaats, String postcode, String straatnaam, String huisnummer, Set<Role> role) {
        this.email = email;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.role = role;
    }

    public Set<Role> getRole() {
        return role;
    }
}
