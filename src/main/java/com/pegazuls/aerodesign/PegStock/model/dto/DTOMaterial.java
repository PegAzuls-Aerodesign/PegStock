package com.pegazuls.aerodesign.PegStock.model.dto;


import java.time.LocalDate;

import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;

public record DTOMaterial(
      Long cod,
      String name,
      String description,
      int quantity,
      Category category,
      Box box,
      LocalDate expirationLocalDate,
      LocalDate createdLocalDate,
      LocalDate registerLocalDate
   ) {
      
      public DTOMaterial(Long cod, String name, String description, int quantity, Category category, Box box, LocalDate expirationLocalDate,
                  LocalDate createdLocalDate, LocalDate registerLocalDate) {
            this.cod = cod;
            this.name = name;
            this.description = description;
            this.quantity = quantity;
            this.category = category;
            this.box = box;
            this.expirationLocalDate = expirationLocalDate;
            this.createdLocalDate = createdLocalDate;
            this.registerLocalDate = registerLocalDate;
      }

      @Override
      public String toString() {
            return "Material [cod=" + cod + ", name=" + name + ", description=" + description + ", quantity=" + quantity
                        + ", category=" + category + ", box=" + box + ", expirationLocalDate=" + expirationLocalDate + ", createdLocalDate="
                        + createdLocalDate + ", registerLocalDate=" + registerLocalDate + "]";
      }

}
