package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Niveau {
    @Id
    @GeneratedValue
    private long niveauID;
    private String niveau;

    @OneToMany (mappedBy = "niveau")
    @JsonManagedReference
    private List<Boek> niveaus;

    public Niveau(String niveau) {
        this.niveau = niveau;
    }
    public Niveau() {}

    public long getNiveauID() {
        return niveauID;
    }

    public void setNiveauID(long niveauID) {
        this.niveauID = niveauID;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public List<Boek> getNiveaus() {
        return niveaus;
    }

    public void setNiveaus(List<Boek> niveaus) {
        this.niveaus = niveaus;
    }
}
