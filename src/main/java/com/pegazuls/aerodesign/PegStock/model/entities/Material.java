package com.pegazuls.aerodesign.PegStock.model.entities;

import java.time.LocalDate;
import java.util.List;

import com.pegazuls.aerodesign.PegStock.model.enums.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

   @OneToMany(mappedBy = "material", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   private List<Borrowing> borrowing;

   public Material() {
      registerDate = LocalDate.now();
   }

}
