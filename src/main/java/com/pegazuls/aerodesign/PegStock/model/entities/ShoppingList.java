package com.pegazuls.aerodesign.PegStock.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "tb_shopping_list")
@Entity(name = "ShoppingList")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;

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

}
