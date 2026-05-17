package com.bruna.webshop.dto;

import com.bruna.webshop.modules.Role;

import java.util.Set;

public class AuthenticationDTO {
    public String email;
    public String userName;
    public String password;
    public String city;
    public String postalCode;
    public String streetName;
    public String houseNumber;
    public Set<Role> role;


    public AuthenticationDTO(String email, String userName, String password, String city, String postalCode, String streetName, String houseNumber, Set<Role> role) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.role = role;
    }

    public Set<Role> getRole() {
        return role;
    }
}
