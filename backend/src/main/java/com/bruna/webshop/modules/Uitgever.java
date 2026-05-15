package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
public class Uitgever {
    @Id
    @GeneratedValue
    private long uitgeverID;

    @NotNull
    private String uitgeverNaam;
    @Column(name="plaatje", columnDefinition = "TEXT")
    private String plaatje;

    @OneToMany(mappedBy = "uitgever")
    @JsonBackReference
    private List<Boek> boekenLijst;

    public Uitgever(String uitgeverNaam, String plaatje) {
        this.uitgeverNaam = uitgeverNaam;
        this.plaatje = plaatje;
    }

    public Uitgever() {
    }

    public long getUitgeverID() {
        return uitgeverID;
    }

    public void setUitgeverID(long uitgeverID) {
        this.uitgeverID = uitgeverID;
    }

    public String getUitgeverNaam() {
        return uitgeverNaam;
    }

    public void setUitgeverNaam(String uitgeverNaam) {
        this.uitgeverNaam = uitgeverNaam;
    }

    public String getPlaatje() {
        return plaatje;
    }

    public void setPlaatje(String plaatje) {
        this.plaatje = plaatje;
    }

    public List<Boek> getBoekenLijst() {
        return boekenLijst;
    }

    public void setBoekenLijst(List<Boek> boekenLijst) {
        this.boekenLijst = boekenLijst;
    }
}
