package com.pegazuls.aerodesign.PegStock.model.dto.material;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

public record DTOMaterialDetails(
      String name,
      int quantity,
      String category,
      String box,
      String expirationDate
) {
      
      public DTOMaterialDetails(Material material) {
         this(
            material.getName(),
            material.getQuantity(),
            material.getCategory().toString(),
            material.getBox().toString(),
            material.getExpirationDate().toString()
         );
      }
   
      @Override
      public String toString() {
         return "Material [name=" + name + ", quantity=" + quantity + ", category=" + category + ", box=" + box + ", expirationDate=" + expirationDate + "]";
      }
}
