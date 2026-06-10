package com.bruna.webshop.dto;

import com.bruna.webshop.modules.Order;
import com.bruna.webshop.modules.Review;

import java.util.List;

public class UserDataDTO {
    public long userID;
    public String userName;
    public String email;
    public String city;
    public String postalCode;
    public String streetName;
    public String houseNumber;
    public List<Order> orderData;
    public List<Review> reviewData;

    public UserDataDTO(long userID, String userName, String email, String city, String postalCode, String streetName, String houseNumber, List<Order> orderData, List<Review> reviewData) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.orderData = orderData;
        this.reviewData = reviewData;
    }
}
