package com.pegazuls.aerodesign.PegStock.controllers.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pegazuls.aerodesign.PegStock.model.dto.brand.DTOBrand;
import com.pegazuls.aerodesign.PegStock.model.entities.Brand;
import com.pegazuls.aerodesign.PegStock.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
   @Autowired
   private BrandService brandService;

   @GetMapping
   public ResponseEntity<List<DTOBrand>> findAll() {
      List<Brand> brands = brandService.findAll();
      if (brands.isEmpty()) {
         return ResponseEntity.noContent().build();
      }

      List<DTOBrand> dtoBrands = brands.stream()
            .map(brand -> new DTOBrand(brand.getName(), brand.getSector(), brand.isSponsorship()))
            .toList();
      return ResponseEntity.ok(dtoBrands);
   }

   @GetMapping("/{id}")
   public ResponseEntity<DTOBrand> findById(@PathVariable Long id) {
      Brand brand = brandService.findById(id);
      return brand == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(new DTOBrand(brand.getName(), brand.getSector(), brand.isSponsorship()));
   }

   @GetMapping("/name/{name}")
   public ResponseEntity<DTOBrand> findByName(@PathVariable String name) {
      Brand brand = brandService.findByName(name);
      return brand == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(new DTOBrand(brand.getName(), brand.getSector(), brand.isSponsorship()));
   }

   @GetMapping("/sector/{sector}")
   public ResponseEntity<List<DTOBrand>> findBySector(@PathVariable String sector) {
      List<Brand> brands = brandService.findBySector(sector);
      if (brands.isEmpty()) {
         return ResponseEntity.noContent().build();
      }

      List<DTOBrand> dtoBrands = brands.stream()
            .map(brand -> new DTOBrand(brand.getName(), brand.getSector(), brand.isSponsorship()))
            .toList();
      return ResponseEntity.ok(dtoBrands);
   }
   
   @PostMapping
   public ResponseEntity<Brand> create(@RequestBody Brand brand, UriComponentsBuilder uriBuilder) {
      Brand createdBrand = brandService.create(brand);
      URI uri = uriBuilder.path("/brand/{id}").buildAndExpand(createdBrand.getCod()).toUri();
      return ResponseEntity.created(uri).body(createdBrand);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Brand> update(@RequestBody Brand brand, @PathVariable Long id) {
      Brand updatedBrand = brandService.update(id, brand);
      return updatedBrand != null ? ResponseEntity.ok(updatedBrand) : ResponseEntity.notFound().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {
      boolean deleted = brandService.delete(id);
      return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
   }

   @GetMapping("/sponsorship/{sponsorship}")
   public ResponseEntity<List<DTOBrand>> findBySponsorship(@PathVariable boolean sponsorship) {
      List<Brand> brands = brandService.findBySponsorship(sponsorship);
      if (brands.isEmpty()) {
         return ResponseEntity.noContent().build();
      }

      List<DTOBrand> dtoBrands = brands.stream()
            .map(brand -> new DTOBrand(brand.getName(), brand.getSector(), brand.isSponsorship()))
            .toList();
      return ResponseEntity.ok(dtoBrands);
   }

}