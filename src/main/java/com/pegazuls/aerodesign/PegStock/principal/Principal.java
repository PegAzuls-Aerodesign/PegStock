package com.pegazuls.aerodesign.PegStock.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.*;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;

import java.time.LocalDate;
import java.util.List;

@Component
public class Principal {

    @Autowired
    private MaterialService materialService;

    public void teste() {
        // Create a new material
        Material material1 = new Material(
            null, 
            "Material 1",
            "Description 1",
            10,
            Category.CONSUMIVEIS,
            Box.ARMARIO4,
            LocalDate.of(2025, 12, 31),
            LocalDate.of(2025, 1, 1),
            LocalDate.now()
        );

        Material material2 = new Material(
            null, 
            "Material 2",
            "Description 2",
            5,
            Category.NAO_CONSUMIVEIS,
            Box.ESTANTE,
            LocalDate.of(2024, 12, 31),
            LocalDate.of(2024, 1, 1),
            LocalDate.now()
        );

        // Save 
        material1 = materialService.create(material1);
        material2 = materialService.create(material2);

        // List all 
        List<Material> materials = materialService.findAll();
        System.out.println("All materials: ");
        for (Material material : materials) {
            System.out.println(material.getName());
        }

        // Find by ID
        Material foundMaterial = materialService.findById(material1.getCod());
        System.out.println("Found material: " + foundMaterial.getName());

        // Update
        material1.setName("Updated Material 1");
        materialService.update(material1, material1.getCod());
        System.out.println("Material 1: " + material1.getName());

        // Check if material is in stock
        boolean isInStock = materialService.isStock(material1.getCod());
        System.out.println("Is material in stock: " + isInStock);
        System.out.println("Material 1 quantity: " + material1.getQuantity());

        // Check if material is expired
        boolean isExpired = materialService.isExpired(material2.getCod());
        System.out.println("Is material expired: " + isExpired);

        // Find the most available material
        Material mostAvailableMaterial = materialService.mostAvailable();
        System.out.println("Most available material: " + mostAvailableMaterial.getName());

        // Find the nearest expiration material
        Material nearestExpirationMaterial = materialService.nearestExpiration();
        System.out.println("Nearest expiration material: " + nearestExpirationMaterial.getName());

        // Delete
        materialService.delete(material1.getCod());
        System.out.println("Material deleted: " + material1.getCod());

         // Check if material exists
         boolean exists = materialService.existsById(material1.getCod());
         System.out.println("Material exists: " + exists);
    }
}