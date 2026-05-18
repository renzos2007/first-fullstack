package com.bruna.webshop.dto;

public class OrderDTO {
    private long productID;
    private int amount;

    public OrderDTO(long productID, int amount) {
        this.productID = productID;
        this.amount = amount;
    }

    public long getProductID() {
        return productID;
    }

    public int getAmount() {
        return amount;
    }
}
