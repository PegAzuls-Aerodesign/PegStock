package com.pegazuls.aerodesign.PegStock.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
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


}
