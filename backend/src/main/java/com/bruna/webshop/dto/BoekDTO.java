package com.bruna.webshop.dto;

import java.util.Set;

public class BoekDTO {
    private String naam;
    private String soort;
    private double prijs;
    private Set<String> genreList;
    private String samenvatting;
    private String taal;
    private int hoeveelheidPaginas;
    private String cover;
    private int voorraad;
    private String plaatje;
    private boolean isBestSeller;

    public BoekDTO(String naam, String soort, double prijs, Set<String> genreList, String samenvatting, String taal, int hoeveelheidPaginas, String cover, int voorraad, String plaatje, boolean isBestSeller) {
        this.naam = naam;
        this.soort = soort;
        this.prijs = prijs;
        this.genreList = genreList;
        this.samenvatting = samenvatting;
        this.taal = taal;
        this.hoeveelheidPaginas = hoeveelheidPaginas;
        this.cover = cover;
        this.voorraad = voorraad;
        this.plaatje = plaatje;
        this.isBestSeller = isBestSeller;
    }
}
