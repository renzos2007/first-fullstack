package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class GebruikerGegevens {
    @Id
    @GeneratedValue
    private long gebruikerID;

    @NotNull
    private String gebruikerNaam;

    @NotNull
    private String wachtwoord;

    @NotNull
    @Column(unique = true)
    private String email;

    private String woonplaats;

    private String postcode;

    private String straatnaam;

    private String huisnummer;

    @OneToMany (mappedBy = "gebruikerGegevens")
    @JsonManagedReference
    private List<Order> orderGegevens;

    @OneToMany (mappedBy = "gebruikerGegevens")
    @JsonManagedReference
    private List<Recensie> recensieGegevens;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public GebruikerGegevens(String gebruikerNaam, String wachtwoord, String email, String woonplaats, String postcode, String straatnaam, String huisnummer) {
        this.gebruikerNaam = gebruikerNaam;
        this.wachtwoord = wachtwoord;
        this.email = email;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
    }

    public GebruikerGegevens() {}

    public long getGebruikerID() {
        return gebruikerID;
    }

    public void setGebruikerID(long gebruikerID) {
        this.gebruikerID = gebruikerID;
    }

    public String getGebruikerNaam() {
        return gebruikerNaam;
    }

    public void setGebruikerNaam(String gebruikerNaam) {
        this.gebruikerNaam = gebruikerNaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public List<Order> getOrderGegevens() {
        return orderGegevens;
    }

    public void setOrderGegevens(List<Order> orderGegevens) {
        this.orderGegevens = orderGegevens;
    }

    public List<Recensie> getRecensieGegevens() {
        return recensieGegevens;
    }

    public void setRecensieGegevens(List<Recensie> recensieGegevens) {
        this.recensieGegevens = recensieGegevens;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
