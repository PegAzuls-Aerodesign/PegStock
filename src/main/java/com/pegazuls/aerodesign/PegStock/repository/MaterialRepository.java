package com.pegazuls.aerodesign.PegStock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;

public interface MaterialRepository extends JpaRepository<Material, Long> {

   List<Material> findByCategory(Category category);

   List<Material> findByBox(Box box);

}
