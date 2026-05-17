package com.bruna.webshop.dto;

public class OrderDTO {
    private long ProductID;
    private int amount;

    public OrderDTO(long ProductID, int amount) {
        this.ProductID = ProductID;
        this.amount = amount;
    }

    public long getProductID() {
        return ProductID;
    }

    public int getAmount() {
        return amount;
    }
}
