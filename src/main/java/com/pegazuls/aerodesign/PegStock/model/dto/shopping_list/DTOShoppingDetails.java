package com.pegazuls.aerodesign.PegStock.model.dto.shopping_list;

import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;



public record DTOShoppingDetails(

        Long cod,
        Long materialCod,
        String nameMaterial,
        String name,
        int quantity,
        double price,
        String supplier,
        String link,
        String description) {


    public DTOShoppingDetails(ShoppingList product) {
        this(product.getCod(), product.getMaterial().getCod(), product.getMaterial().getName(), product.getProductName(), product.getQuantity(), product.getPrice(), product.getSupplier(), product.getLink(), product.getDescription());
    }

    @Override
    public String toString() {
        return "name:'" + name + ", quantity: " + quantity + ", price: R$" + price + ", supplier: " + supplier + ", link: " + link;
    }
}
