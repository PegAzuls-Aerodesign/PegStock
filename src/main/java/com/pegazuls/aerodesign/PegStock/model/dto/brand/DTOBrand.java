package com.pegazuls.aerodesign.PegStock.model.dto.brand;

public record DTOBrand(
         String name,
         String sector,
         boolean sponsorship
) {

   public DTOBrand(String name, String sector, boolean sponsorship) {
      this.name = name;
      this.sector = sector;
      this.sponsorship = sponsorship;
   }

}
