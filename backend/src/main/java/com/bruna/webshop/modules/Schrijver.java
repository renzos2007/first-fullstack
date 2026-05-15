package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
public class Schrijver {
    @Id
    @GeneratedValue
    private long schrijverID;
    @NotNull
    private String voornaam;
    private String tussenvoegsel;
    @NotNull
    private String achternaam;

    @OneToMany(mappedBy = "schrijver")
    @JsonBackReference
    private List<Boek> boekenlijst;

    public Schrijver(String voornaam, String tussenvoegsel, String achternaam) {
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
    }

    public Schrijver() {
    }

    public long getSchrijverID() {
        return schrijverID;
    }

    public void setSchrijverID(long schrijverID) {
        this.schrijverID = schrijverID;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public List<Boek> getBoekenlijst() {
        return boekenlijst;
    }

    public void setBoekenlijst(List<Boek> boekenlijst) {
        this.boekenlijst = boekenlijst;
    }
}
