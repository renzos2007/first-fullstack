package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class OrderRegel {
    @Id
    @GeneratedValue()
    private long OrderRegelId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    Order order;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonManagedReference
    Boek boek;

    private int hoeveelheid;

    public OrderRegel(Order order, Boek boek, int hoeveelheid) {
        this.order = order;
        this.boek = boek;
        this.hoeveelheid = hoeveelheid;
    }

    public OrderRegel() {
    }

    public long getOrderRegelId() {
        return OrderRegelId;
    }

    public void setOrderRegelId(long orderRegelId) {
        OrderRegelId = orderRegelId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Boek getBoek() {
        return boek;
    }

    public void setBoek(Boek boek) {
        this.boek = boek;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }
}
