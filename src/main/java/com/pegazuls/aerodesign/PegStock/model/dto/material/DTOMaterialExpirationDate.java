package com.pegazuls.aerodesign.PegStock.model.dto.material;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

import java.time.LocalDate;

public record DTOMaterialExpirationDate(String name, LocalDate expirationDate) {

    public DTOMaterialExpirationDate(Material material) {
        this(material.getName(), material.getExpirationDate());
    }

    @Override
    public String toString() {
        return "Material [name=" + name + ", expirationLocalDate=" + expirationDate + "]";
    }
}
