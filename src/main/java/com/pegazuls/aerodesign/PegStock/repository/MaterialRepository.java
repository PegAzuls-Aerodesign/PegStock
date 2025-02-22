package com.pegazuls.aerodesign.PegStock.repository;

import com.pegazuls.aerodesign.PegStock.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    // create with derived query a  method to search the CONSUMIVEIS category with quantity less than 7
    List<Material> findByCategoryAndQuantityLessThan(Category category, int quantity);
}
