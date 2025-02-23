package com.pegazuls.aerodesign.PegStock.model.dto.shopping_list;

import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;

public record DTOShoppingSummary(
        String name,
        double price) {
    public DTOShoppingSummary(ShoppingList product) {
        this(product.getProductName(), product.getPrice());
    }

    @Override
    public String toString() {
        return "name:'" + name + ", price: R$" + price ;
    }
}
