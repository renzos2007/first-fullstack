package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.Set;

@Entity
public class Boek {
    @Id
    @GeneratedValue
    private long boekID;
    @NotNull
    private String naam;
    @NotNull
    private String soort;
    @NotNull
    private double prijs;

    @ManyToMany (cascade = CascadeType.MERGE)
    @JoinTable (name = "genre_jointable")
    @JsonManagedReference
    Set<Genre> genreList;

    @NotNull
    @Column(name="samenvatting", columnDefinition = "TEXT")
    private String samenvatting;
    @NotNull
    private String taal;
    @NotNull
    private int hoeveelheidPaginas;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "schrijver_ID")
    @JsonManagedReference
    private Schrijver schrijver;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "uitgever_ID")
    @JsonManagedReference
    private Uitgever uitgever;
    private String cover;
    private int voorraad;

    @OneToMany(mappedBy = "boek")
    @JsonManagedReference
    private List<Recensie> recensie;

    @Column(name="plaatje", columnDefinition = "TEXT")
    private String plaatje;
    private boolean bestSeller;
    @OneToMany(mappedBy = "boek")
    @JsonBackReference
    private List<OrderRegel> besteld;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Niveau niveau;

    public Boek(String naam, String soort, double prijs, String samenvatting, String taal, int hoeveelheidPaginas, Schrijver schrijver, Uitgever uitgever, String cover, int voorraad, String plaatje, boolean bestSeller, Niveau niveau) {
        this.naam = naam;
        this.soort = soort;
        this.prijs = prijs;
        this.samenvatting = samenvatting;
        this.taal = taal;
        this.hoeveelheidPaginas = hoeveelheidPaginas;
        this.schrijver = schrijver;
        this.uitgever = uitgever;
        this.cover = cover;
        this.voorraad = voorraad;
        this.plaatje = plaatje;
        this.bestSeller = bestSeller;
        this.niveau = niveau;
    }

    public Boek() {
    }

    public long getBoekID() {
        return boekID;
    }

    public void setBoekID(long boekID) {
        this.boekID = boekID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public Set<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(Set<Genre> genreList) {
        this.genreList = genreList;
    }

    public String getSamenvatting() {
        return samenvatting;
    }

    public void setSamenvatting(String samenvatting) {
        this.samenvatting = samenvatting;
    }

    public String getTaal() {
        return taal;
    }

    public void setTaal(String taal) {
        this.taal = taal;
    }

    public int getHoeveelheidPaginas() {
        return hoeveelheidPaginas;
    }

    public void setHoeveelheidPaginas(int hoeveelheidPaginas) {
        this.hoeveelheidPaginas = hoeveelheidPaginas;
    }

    public Schrijver getSchrijver() {
        return schrijver;
    }

    public void setSchrijver(Schrijver schrijver) {
        this.schrijver = schrijver;
    }

    public Uitgever getUitgever() {
        return uitgever;
    }

    public void setUitgever(Uitgever uitgever) {
        this.uitgever = uitgever;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    public List<Recensie> getRecensie() {
        return recensie;
    }

    public void setRecensie(List<Recensie> recensie) {
        this.recensie = recensie;
    }

    public String getPlaatje() {
        return plaatje;
    }

    public void setPlaatje(String plaatje) {
        this.plaatje = plaatje;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public List<OrderRegel> getBesteld() {
        return besteld;
    }

    public void setBesteld(List<OrderRegel> besteld) {
        this.besteld = besteld;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}