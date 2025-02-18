package com.pegazuls.aerodesign.PegStock.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "tb_shopping_list")
@Entity(name = "ShoppingList")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cod;
    private String productName;
    private int quantity;
    private double price;
    private String supplier;
    private LocalDate date;
    private String link;

    public ShoppingList(String productName, int quantity, double price, String supplier, String link) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
        this.date = LocalDate.now();
        this.link = link;
    }

    public ShoppingList() {
    }

    public long getCod() {
        return cod;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingList that)) return false;
        return getCod() == that.getCod();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod());
    }


}
