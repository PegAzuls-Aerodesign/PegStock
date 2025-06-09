package com.pegazuls.aerodesign.PegStock.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity(name = "tb_brand")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cod;

   @Column(nullable = false, unique = true)
   private String name;

   @Column(nullable = false)
   private String sector;

   @Column(nullable = false)
   private boolean sponsorship;

   public boolean isSponsorship() {
      return sponsorship;
   }
}
