package com.pegazuls.aerodesign.PegStock.model.dto.material;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

public record DTOLowStockMaterial(
        String name,
        int quantity
) {
    public DTOLowStockMaterial(Material material) {
        this(material.getName(), material.getQuantity());
    }

    public String toString() {
        return name + " \nQuantidade restante: " + quantity;
    }
}
