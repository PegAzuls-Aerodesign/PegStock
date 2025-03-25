package com.pegazuls.aerodesign.PegStock.repository;

import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    ShoppingList findFirstByOrderByPriceDesc();

    List<ShoppingList> findByProductName(String productName);
}
