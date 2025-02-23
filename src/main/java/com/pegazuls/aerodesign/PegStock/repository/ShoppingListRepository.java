package com.pegazuls.aerodesign.PegStock.repository;

import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    ShoppingList findFirstByOrderByPriceDesc();

    ShoppingList findByProductName(String productName);
}
