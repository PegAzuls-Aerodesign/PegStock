package com.pegazuls.aerodesign.PegStock.model.dto;

import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;

public record DTOShoppingDetails(
        String name,
        int quantity,
        double price,
        String supplier,
        String link) {


    public DTOShoppingDetails(ShoppingList product) {
        this(product.getProductName(), product.getQuantity(), product.getPrice(), product.getSupplier(), product.getLink());
    }

    @Override
    public String toString() {
        return "name:'" + name + ", quantity: " + quantity + ", price: R$" + price + ", supplier: " + supplier + ", link: " + link;
    }
}
