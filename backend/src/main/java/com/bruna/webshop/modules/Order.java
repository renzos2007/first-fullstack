package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private long orderNumber;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderRegel> besteldeBoeken = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private GebruikerGegevens gebruikerGegevens;

    private LocalDate orderDatum = LocalDate.now();

    private boolean afgehandeld = false;



    public Order() {
    }

    public Order(GebruikerGegevens gebruikerGegevens) {
        this.gebruikerGegevens = gebruikerGegevens;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderRegel> getBesteldeBoeken() {
        return besteldeBoeken;
    }

    public void setBesteldeBoeken(List<OrderRegel> besteldeBoeken) {
        this.besteldeBoeken = besteldeBoeken;
    }

    public GebruikerGegevens getGebruikerGegevens() {
        return gebruikerGegevens;
    }

    public void setGebruikerGegevens(GebruikerGegevens gebruikerGegevens) {
        this.gebruikerGegevens = gebruikerGegevens;
    }

    public LocalDate getOrderDatum() {
        return orderDatum;
    }

    public void setOrderDatum(LocalDate orderDatum) {
        this.orderDatum = orderDatum;
    }

    public boolean isAfgehandeld() {
        return afgehandeld;
    }

    public void setAfgehandeld(boolean afgehandeld) {
        this.afgehandeld = afgehandeld;
    }
}
