package com.pegazuls.aerodesign.PegStock.model.dto.material;


import java.time.LocalDate;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;

public record DTOMaterial(
        Long cod,
      String name,
      String description,
      String brand,
      int quantity,
      Category category,
      Box box,
      LocalDate expirationDate
   ) {
      
        public DTOMaterial(Material material) {
                this(material.getCod(), material.getName(), material.getDescription(), material.getBrand(), material.getQuantity(), material.getCategory(), material.getBox(), material.getExpirationDate());
      }

}
