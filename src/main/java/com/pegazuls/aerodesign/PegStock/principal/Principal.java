package com.pegazuls.aerodesign.PegStock.principal;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Principal {


    @Autowired
    private MaterialService service;

    public void teste() {

        List<Material> materials = service.lowStockMaterials();

        for (Material material : materials) {
            System.out.println(material);
        }
    }

    private static Material createMaterial(String name, String description, int quantity, Category category, Box box, String expirationDate, String createdDate) {
        Material material = new Material();
        material.setName(name);
        material.setDescription(description);
        material.setQuantity(quantity);
        material.setCategory(category);
        material.setBox(box);
        material.setExpirationDate(LocalDate.parse(expirationDate));
        material.setCreatedDate(LocalDate.parse(createdDate));
        return material;
    }
}