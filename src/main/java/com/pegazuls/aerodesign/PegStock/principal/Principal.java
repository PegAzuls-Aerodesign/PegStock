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

        // Testing findALL
        List<DTOShoppingDetails> products = service.findAll();

        products.forEach(System.out::println);

        // Testing findByName
        DTOShoppingDetails product = service.findById(1L);
        System.out.println(product);

        // Testing findByMostExpensive
        DTOShoppingSummary expensive = service.findMostExpensive();
        System.out.println(expensive);

        // Testing delete
        service.delete(1L);
        products = service.findAll();
        products.forEach(System.out::println);
    }
}
