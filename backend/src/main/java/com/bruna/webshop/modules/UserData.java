package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_data")
public class UserData {
    @Id
    @GeneratedValue
    @Column(name="user_id", columnDefinition = "TEXT")
    private long userID;

    @NotNull
    @Column(name="user_name", columnDefinition = "TEXT")
    private String userName;

    @NotNull
    private String password;

    @NotNull
    @Column(unique = true)
    private String email;

    private String city;

    @Column(name="postal_code", columnDefinition = "TEXT")
    private String postalCode;

    @Column(name="street_name", columnDefinition = "TEXT")
    private String streetName;

    @Column(name="house_number", columnDefinition = "TEXT")
    private String houseNumber;

    @OneToMany (mappedBy = "gebruikerGegevens")
    @JsonManagedReference
    @Column(name="order_date", columnDefinition = "TEXT")
    private List<Order> orderData;

    @OneToMany (mappedBy = "gebruikerGegevens")
    @JsonManagedReference
    @Column(name="review_data", columnDefinition = "TEXT")
    private List<Review> reviewData;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public UserData(String userName, String password, String email, String city, String postalCode, String streetName, String houseNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public UserData() {}

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public List<Order> getOrderData() {
        return orderData;
    }

    public void setOrderData(List<Order> orderData) {
        this.orderData = orderData;
    }

    public List<Review> getReviewData() {
        return reviewData;
    }

    public void setReviewData(List<Review> reviewData) {
        this.reviewData = reviewData;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
