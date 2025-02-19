package com.pegazuls.aerodesign.PegStock.model.entities;

import java.time.LocalDate;

import com.pegazuls.aerodesign.PegStock.model.enums.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity(name = "tb_material")
@Getter
@Setter
@AllArgsConstructor
public class Material {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cod;

   private String name;

   private String description;

   private int quantity;

   private Category category;

   private Box box;

   private LocalDate expirationDate; // data de validade
 
   private LocalDate createdDate; // data de fabricação

   private LocalDate registerDate; // data de registro no sistema

   public Material() {
      registerDate = LocalDate.now();
   }
   
}
