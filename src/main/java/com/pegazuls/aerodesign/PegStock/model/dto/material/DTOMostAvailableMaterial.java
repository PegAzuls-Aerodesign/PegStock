package com.pegazuls.aerodesign.PegStock.model.dto.material;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

public record DTOMostAvailableMaterial(String name, int quantity) {
    public DTOMostAvailableMaterial(Material material) {
        this(material.getName(), material.getQuantity());
    }

    @Override
    public String toString() {
        return "Material [name=" + name + ", quantity=" + quantity + "]";
    }
}
