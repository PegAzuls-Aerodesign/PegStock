package com.pegazuls.aerodesign.PegStock.model.dto.material;


import java.time.LocalDate;

import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;

public record DTOMaterial(
      String name,
      String description,
      String brand,
      int quantity,
      Category category,
      Box box,
      LocalDate expirationLocalDate,
      LocalDate createdLocalDate,
      LocalDate registerLocalDate
) {
      
      public DTOMaterial(String name, String description, String brand, int quantity, Category category, Box box, LocalDate expirationLocalDate,
                  LocalDate createdLocalDate, LocalDate registerLocalDate) {
            this.name = name;
            this.description = description;
            this.brand = brand;
            this.quantity = quantity;
            this.category = category;
            this.box = box;
            this.expirationLocalDate = expirationLocalDate;
            this.createdLocalDate = createdLocalDate;
            this.registerLocalDate = registerLocalDate;
      }

      @Override
      public String toString() {
            return "Material [name=" + name + ", description=" + description + ", brand=" + brand + ", quantity=" + quantity
                        + ", category=" + category + ", box=" + box + ", expirationLocalDate=" + expirationLocalDate + ", createdLocalDate="
                        + createdLocalDate + ", registerLocalDate=" + registerLocalDate + "]";
      }

}
