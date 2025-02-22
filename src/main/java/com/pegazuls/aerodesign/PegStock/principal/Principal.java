package com.pegazuls.aerodesign.PegStock.principal;

import com.pegazuls.aerodesign.PegStock.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Principal {

    @Autowired
    private ShoppingListService service;

    public void teste() {
        service.generateShoppingListCSV();
    }

}