package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recensie {
    @Id
    @GeneratedValue
    private long recentieID;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Boek boek;
    private int rating;
    private String recentie;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private GebruikerGegevens gebruikerGegevens;

    public Recensie(Boek boek, int rating, String recentie, GebruikerGegevens gebruikerGegevens) {
        this.boek = boek;
        this.rating = rating;
        this.recentie = recentie;
        this.gebruikerGegevens = gebruikerGegevens;
    }

    public Recensie() {}

    public long getRecentieID() {
        return recentieID;
    }

    public void setRecentieID(long recentieID) {
        this.recentieID = recentieID;
    }

    public Boek getBoek() {
        return boek;
    }

    public void setBoek(Boek boek) {
        this.boek = boek;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRecentie() {
        return recentie;
    }

    public void setRecentie(String recentie) {
        this.recentie = recentie;
    }

    public GebruikerGegevens getGebruikerGegevens() {
        return gebruikerGegevens;
    }

    public void setGebruikerGegevens(GebruikerGegevens gebruikerGegevens) {
        this.gebruikerGegevens = gebruikerGegevens;
    }
}
