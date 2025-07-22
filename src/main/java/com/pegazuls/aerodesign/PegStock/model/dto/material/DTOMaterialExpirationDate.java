package com.pegazuls.aerodesign.PegStock.model.dto.material;

import java.time.LocalDate;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

public record DTOMaterialExpirationDate(String name, LocalDate expirationDate) {

    public DTOMaterialExpirationDate(Material material) {
        this(material.getName(), material.getExpirationDate());
    }

    @Override
    public String toString() {
        return "Material [name=" + name + ", expirationDate=" + expirationDate + "]";
    }
}
