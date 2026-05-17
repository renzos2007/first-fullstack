package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue
    @Column(name="publisher_id", columnDefinition = "TEXT")
    private long publisherID;

    @NotNull
    @Column(name="publisher_name", columnDefinition = "TEXT")
    private String publisherName;

    @Column(name="image", columnDefinition = "TEXT")
    private String image;

    @OneToMany(mappedBy = "publisher")
    @JsonBackReference
    @Column(name="product_list", columnDefinition = "TEXT")
    private List<Product> ProductList;

    public Publisher(String publisherName, String image) {
        this.publisherName = publisherName;
        this.image = image;
    }

    public Publisher() {
    }

    public long getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(long publisherID) {
        this.publisherID = publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProductList() {
        return ProductList;
    }

    public void setProductList(List<Product> productList) {
        ProductList = productList;
    }
}
