package com.pegazuls.aerodesign.PegStock.service;

import java.time.LocalDate;
import java.util.List;

import com.pegazuls.aerodesign.PegStock.model.dto.DTOBorrowingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.repository.MaterialRepository;

import jakarta.transaction.Transactional;

@Service
public class MaterialService {

   @Autowired
   private MaterialRepository materialRepository;

   // Register new product
   @Transactional
   public Material create(Material material) {
      return materialRepository.save(material);
   }

   public List<DTOBorrowingDetails> getBorrowings(Long cod) {
      Material material = materialRepository.findById(cod).orElseThrow();
      return material.getBorrowing().stream().map(DTOBorrowingDetails::new).toList();
   }


   // List products
   public List<Material> findAll() {
      return materialRepository.findAll();
   }

   // Search product by id
   public Material findById(Long id) {
      return materialRepository.findById(id).orElse(null);
   }

   // Update product
   @Transactional
   public void update(Material material, Long id) {
      Material materialUpdate = materialRepository.findById(id).orElse(null);

      materialUpdate.setName(material.getName());
      materialUpdate.setDescription(material.getDescription());
      materialUpdate.setQuantity(material.getQuantity());
      materialUpdate.setCategory(material.getCategory());
      materialUpdate.setBox(material.getBox());
      materialUpdate.setExpirationDate(material.getExpirationDate());
      materialUpdate.setCreatedDate(material.getCreatedDate());
   }

   // Delete product
   public void delete(Long id) {
      materialRepository.deleteById(id);
   }

   // Check if product exists
   public boolean existsById(Long id) {
      return materialRepository.existsById(id);
   }

   // Method to verify if the product is in stock
   public boolean isStock(Long id) {
      Material material = materialRepository.findById(id).orElse(null);

      if (material.getQuantity() > 0) {
         return true;
      } else {
         return false;
      }
   }

   // Method to verify if the product is expired
   public boolean isExpired(Long id) {
      Material material = materialRepository.findById(id).orElse(null);

      if (LocalDate.now().isAfter(material.getExpirationDate())) {
         return true;
      } else {
         return false;
      }
   }

   // Method to verify most available product ; dá pra fazer o de menos disponível tb 
   public Material mostAvailable() {
      List<Material> materials = materialRepository.findAll();
      Material material = materials.get(0);

      for (Material m : materials) {
         if (m.getQuantity() > material.getQuantity()) {
            material = m;
         }
      }

      return material;
   }

   // Method to verify nearest expiration product
   public Material nearestExpiration() {
      List<Material> materials = materialRepository.findAll();
      Material material = materials.get(0);

      for (Material m : materials) {
         if (m.getExpirationDate().isBefore(material.getExpirationDate())) {
            material = m;
         }
      }

      return material;
   }
   
}
