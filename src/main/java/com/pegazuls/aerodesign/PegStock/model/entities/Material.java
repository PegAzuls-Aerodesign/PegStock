package com.pegazuls.aerodesign.PegStock.model.entities;

import java.time.LocalDate;
import java.util.List;

import com.pegazuls.aerodesign.PegStock.model.enums.*;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity(name = "tb_material")
@Getter
@Setter
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

   public Material(Long cod, String name, String description, int quantity, Category category, Box box, LocalDate expirationDate, LocalDate createdDate, LocalDate registerDate, List<Borrowing> borrowing) {
      this.cod = cod;
      this.name = name;
      this.description = description;
      this.quantity = quantity;
      this.category = category;
      this.box = box;
      this.expirationDate = expirationDate;
      this.createdDate = createdDate;
      this.registerDate = registerDate;
      this.borrowing = borrowing;
   }

   public Material() {
      registerDate = LocalDate.now();
   }

   public Material(Object o, LocalDate now, LocalDate now1, LocalDate now2, Box box, Category category, int i, String s, String s1) {
   }

   public List<Borrowing> getBorrowing() {
      return borrowing;
   }

   public void setBorrowing(List<Borrowing> borrowing) {
      this.borrowing = borrowing;
   }

   public LocalDate getRegisterDate() {
      return registerDate;
   }

   public void setRegisterDate(LocalDate registerDate) {
      this.registerDate = registerDate;
   }

   public LocalDate getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(LocalDate createdDate) {
      this.createdDate = createdDate;
   }

   public LocalDate getExpirationDate() {
      return expirationDate;
   }

   public void setExpirationDate(LocalDate expirationDate) {
      this.expirationDate = expirationDate;
   }

   public Box getBox() {
      return box;
   }

   public void setBox(Box box) {
      this.box = box;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Long getCod() {
      return cod;
   }

   public void setCod(Long cod) {
      this.cod = cod;
   }


}
