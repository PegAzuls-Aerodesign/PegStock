package com.pegazuls.aerodesign.PegStock.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "tb_shopping_list")
@Entity(name = "ShoppingList")
@Getter
@Setter
@NoArgsConstructor
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cod;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String supplier;
    private LocalDate date;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String description;

    private Double totalValue;

    public ShoppingList(String productName, int quantity, double price, String supplier, String link, String description) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.supplier = supplier;
        this.date = LocalDate.now();
        this.link = link;
        this.description = description;
        this.totalValue = quantity * price;
    }



}
