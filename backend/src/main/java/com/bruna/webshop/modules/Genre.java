package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue
    private long genreId;

    private String naam;

    @ManyToMany(mappedBy = "genreList")
    @JsonBackReference
    Set<Boek> boekenList;

    public Genre() {}

    public Genre(String naam) {
        this.naam = naam;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Set<Boek> getBoekenList() {
        return boekenList;
    }

    public void setBoekenList(Set<Boek> boekenList) {
        this.boekenList = boekenList;
    }
}
