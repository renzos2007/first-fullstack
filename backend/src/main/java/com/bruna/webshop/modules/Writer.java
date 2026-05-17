package com.bruna.webshop.modules;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Writer {
    @Id
    @GeneratedValue
    @Column(name="writer_id")
    private long writerID;

    @NotNull
    private String name;

    @Column(name="middle_name")
    private String middleName;

    @NotNull
    private String surname;

    @OneToMany(mappedBy = "writer")
    @JsonBackReference
    private List<Product> productList;

    public Writer(String name, String middleName, String surname) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
    }

    public Writer() {
    }

    public long getWriterID() {
        return writerID;
    }

    public void setWriterID(long writerID) {
        this.writerID = writerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
