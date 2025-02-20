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
            LocalDate.of(2025, 12, 31),
            LocalDate.of(2024, 1, 1),
            LocalDate.now()
        );

        Material material3 = new Material(
            null, 
            "Material 2",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus lorem purus, maximus sed sollicitudin vel, varius in mauris.",
            50,
            Category.NAO_CONSUMIVEIS,
            Box.ESTANTE,
            LocalDate.of(2025, 12, 31),
            LocalDate.of(2024, 1, 1),
            LocalDate.now()
        );

        // Save 
        material1 = materialService.create(material1);
        material2 = materialService.create(material2);
        material3 = materialService.create(material3);

        // List all 
        List<Material> materials = materialService.findAll();
        System.out.println("All materials: ");
        for (Material material : materials) {
            System.out.println(material.getName());
        }

    }
}