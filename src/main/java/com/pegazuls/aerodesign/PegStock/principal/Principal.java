package com.pegazuls.aerodesign.PegStock.principal;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import org.springframework.stereotype.Component;

@Component
public class Principal {


    public void teste() {
        Material material = new Material();

        material.setName("Teste");
        material.setDescription("Teste");
        System.out.println(material.getName());
    }
}