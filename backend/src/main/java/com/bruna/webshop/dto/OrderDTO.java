package com.bruna.webshop.dto;

public class OrderDTO {
    private long boekID;
    private int hoeveelheid;

    public OrderDTO(long boekID, int hoeveelheid) {
        this.boekID = boekID;
        this.hoeveelheid = hoeveelheid;
    }

    public long getBoekID() {
        return boekID;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }
}
