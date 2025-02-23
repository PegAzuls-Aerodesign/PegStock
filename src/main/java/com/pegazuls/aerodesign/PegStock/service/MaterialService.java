package com.pegazuls.aerodesign.PegStock.service;

import java.time.LocalDate;
import java.util.List;

import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOBorrowingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegazuls.aerodesign.PegStock.infra.validation.material.ValidationMaterial;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;
import com.pegazuls.aerodesign.PegStock.repository.MaterialRepository;

import jakarta.transaction.Transactional;

@Service
public class MaterialService {

   @Autowired
   private MaterialRepository materialRepository;
   @Autowired
   private List<ValidationMaterial> validations;

   // Register new product
   @Transactional
   public Material create(Material material) {
      validations.forEach(v -> v.validate(material));
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
      validations.forEach(v -> v.validate(material));
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
      return material != null && material.getQuantity() > 0;
   }

   // Method to verify if the product is expired
   public boolean isExpired(Long id) {
      Material material = materialRepository.findById(id).orElse(null);
      return material != null && LocalDate.now().isAfter(material.getExpirationDate());
   }

   // Method to verify most available product
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

   // List products by category
   public List<Material> findByCategory(Category category) {
      return materialRepository.findByCategory(category);
   }

   // List products by box
   public List<Material> findByBox(Box box) {
      return materialRepository.findByBox(box);
   }

   // list expired products
   public List<Material> findExpired() {
      List<Material> materials = materialRepository.findAll();
      materials.removeIf(m -> !isExpired(m.getCod()));
      return materials;
   }

   // list products about to expire (30 days)
   public List<Material> findAboutToExpire() {
      List<Material> materials = materialRepository.findAll();
      materials.removeIf(m -> !m.getExpirationDate().isBefore(LocalDate.now().plusDays(30)) || isExpired(m.getCod()));
      return materials;
   }

   // filter products by multiple criteria (category, box, expirated, stock)
   public List<Material> filter(Category category, Box box, boolean expired, boolean stock) {
      List<Material> materials = materialRepository.findAll();

      if (category != null) {
         materials.removeIf(m -> m.getCategory() != category);
      }
      if (box != null) {
         materials.removeIf(m -> m.getBox() != box);
      }
      if (expired) {
         materials.removeIf(m -> !isExpired(m.getCod()));
      }
      if (stock) {
         materials.removeIf(m -> !isStock(m.getCod()));
      }
      return materials;
   }

}