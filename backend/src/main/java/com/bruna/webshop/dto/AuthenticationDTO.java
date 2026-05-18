package com.bruna.webshop.dto;

public class AuthenticationDTO {
    public String email;
    public String userName;
    public String password;
    public String city;
    public String postalCode;
    public String streetName;
    public String houseNumber;


    public AuthenticationDTO(String email, String userName, String password, String city, String postalCode, String streetName, String houseNumber) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }
}
