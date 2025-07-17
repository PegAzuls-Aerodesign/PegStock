package com.pegazuls.aerodesign.PegStock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegazuls.aerodesign.PegStock.model.entities.Brand;
import com.pegazuls.aerodesign.PegStock.repository.BrandRepository;

import jakarta.transaction.Transactional;

@Service
public class BrandService {
   @Autowired
   private BrandRepository brandRepository;

   // TO-DO: Validations

   @Transactional
   public Brand create(Brand brand) {
      return brandRepository.save(brand);
   }

   public Brand findById(Long id) {
      return brandRepository.findById(id).orElse(null);
   }

   public Brand findByName(String name) {
      return brandRepository.findAll().stream()
            .filter(brand -> brand.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
   }

   public List<Brand> findAll() {
      return brandRepository.findAll();
   }

   @Transactional
   public Brand update(Long id, Brand brand) {
      Brand existingBrand = findById(id);
      if (existingBrand != null) {
         existingBrand.setName(brand.getName());
         existingBrand.setSector(brand.getSector());
         existingBrand.setSponsorship(brand.isSponsorship());
         return brandRepository.save(existingBrand);
      }
      return null; 
   }

   public boolean delete(Long id) {
      if (!brandRepository.existsById(id)) {
         return false; 
      }
      brandRepository.deleteById(id);
      return true;
   }

   public List<Brand> findBySector(String sector) {
      return brandRepository.findAll().stream()
            .filter(brand -> brand.getSector().equalsIgnoreCase(sector))
            .toList();
   }

   public List<Brand> findBySponsorship(boolean sponsorship) {
      return brandRepository.findAll().stream()
            .filter(brand -> brand.isSponsorship() == sponsorship)
            .toList();
   }
}
