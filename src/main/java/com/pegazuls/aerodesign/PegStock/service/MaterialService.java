package com.pegazuls.aerodesign.PegStock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.repository.MaterialRepository;

public class MaterialService {

   @Autowired
   private MaterialRepository materialRepository;

   // Register new product
   public Material create(Material material) {
      return materialRepository.save(material);
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
}
