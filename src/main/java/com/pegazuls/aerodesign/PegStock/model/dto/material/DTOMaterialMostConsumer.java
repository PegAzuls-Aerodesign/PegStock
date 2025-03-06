package com.pegazuls.aerodesign.PegStock.model.dto.material;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

public record DTOMaterialMostConsumer(String name, int quantity) {
        public DTOMaterialMostConsumer(Material material) {
            this(material.getName(), material.getConsumerQuantity());
        }

        @Override
        public String toString() {
            return "Material [name=" + name + ", quantity=" + quantity + "]";
        }
}
