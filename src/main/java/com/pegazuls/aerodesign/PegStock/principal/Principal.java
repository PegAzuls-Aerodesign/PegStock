package com.pegazuls.aerodesign.PegStock.principal;

import com.pegazuls.aerodesign.PegStock.model.dto.DTOShoppingDetails;
import com.pegazuls.aerodesign.PegStock.model.dto.DTOShoppingSummary;
import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import com.pegazuls.aerodesign.PegStock.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Principal {

    @Autowired
    private ShoppingListService service;
    private List<ShoppingList> products = new ArrayList<>();

    public void teste() {

        // try to create a shoppinglist with null fields
        ShoppingList shoppingList = new ShoppingList("produto 9", -5, 70, "organizações tabajara", "www.google.com");
        service.create(shoppingList);

    }
}
