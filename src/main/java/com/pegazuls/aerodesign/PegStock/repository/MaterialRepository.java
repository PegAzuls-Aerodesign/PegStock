package com.pegazuls.aerodesign.PegStock.repository;

import java.util.List;

import com.pegazuls.aerodesign.PegStock.model.enums.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;

public interface MaterialRepository extends JpaRepository<Material, Long> {

   List<Material> findByCategory(Category category);

   List<Material> findByBox(Box box);
  
    // create with derived query a  method to search the CONSUMIVEIS category with quantity less than 7
    List<Material> findByCategoryAndQuantityLessThan(Category category, int quantity);

    // return the most consumed material
    Material findFirstByOrderByConsumerQuantityDesc();

}
