package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    @Column(name="review_id", columnDefinition = "TEXT")
    private long reviewID;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Product product;

    private int rating;

    @Column(name="review_text", columnDefinition = "TEXT")
    private String reviewText;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @Column(name="user_data", columnDefinition = "TEXT")
    private UserData userData;

    public Review(Product product, int rating, String reviewText, UserData userData) {
        this.product = product;
        this.rating = rating;
        this.reviewText = reviewText;
        this.userData = userData;
    }

    public Review() {}

    public long getReviewID() {
        return reviewID;
    }

    public void setReviewID(long reviewID) {
        this.reviewID = reviewID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
