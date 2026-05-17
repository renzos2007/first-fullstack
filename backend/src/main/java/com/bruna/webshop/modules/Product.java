package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name="product_id", columnDefinition = "TEXT")
    private long productID;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private double price;

    @ManyToMany (cascade = CascadeType.MERGE)
    @JoinTable (name = "genre_join_table")
    @JsonManagedReference
    @Column(name="genre_list", columnDefinition = "TEXT")
    private List<Genre> genreList;

    @NotNull
    @Column(name="summary", columnDefinition = "TEXT")
    private String summary;

    @NotNull
    private String language;

    @NotNull
    private int pages;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "writer_id")
    @JsonManagedReference
    private Writer writer;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "publisher_id")
    @JsonManagedReference
    private Publisher publisher;

    private String cover;

    private int stock;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Review> review;

    @Column(name="image", columnDefinition = "TEXT")
    private String image;

    @Column(name="best_seller", columnDefinition = "TEXT")
    private boolean bestSeller;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<OrderItem> orders;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Difficulty difficulty;

    public Product(String name, String type, double price, String summary, String language, int pages, Writer writer, Publisher publisher, String cover, int stock, String image, boolean bestSeller, Difficulty difficulty) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.summary = summary;
        this.language = language;
        this.pages = pages;
        this.writer = writer;
        this.publisher = publisher;
        this.cover = cover;
        this.stock = stock;
        this.image = image;
        this.bestSeller = bestSeller;
        this.difficulty = difficulty;
    }

    public Product() {
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}