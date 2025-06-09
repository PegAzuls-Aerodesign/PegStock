package com.pegazuls.aerodesign.PegStock.model.dto.material;


import java.time.LocalDate;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;

public record DTOMaterial(
        Long cod,
      String name,
      int quantity,
      Category category,
      Box box,
      LocalDate expirationLocalDate
   ) {
      
        public DTOMaterial(Material material) {
                this(material.getCod(), material.getName(), material.getQuantity(), material.getCategory(), material.getBox(), material.getExpirationDate());
        }

    @Override
    public String toString() {
        return "DTOMaterial{" +
                "cod=" + cod +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", category=" + category +
                ", box=" + box +
                ", expirationLocalDate=" + expirationLocalDate +
                '}';
    }
}
