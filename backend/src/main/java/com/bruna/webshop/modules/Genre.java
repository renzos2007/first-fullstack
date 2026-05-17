package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue
    @Column(name="genre_id", columnDefinition = "TEXT")
    private long genreID;

    private String name;

    @ManyToMany(mappedBy = "genreList")
    @JsonBackReference
    @Column(name="product_list", columnDefinition = "TEXT")
    private List<Product> productList;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {}

    public long getGenreID() {
        return genreID;
    }

    public void setGenreID(long genreID) {
        this.genreID = genreID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
