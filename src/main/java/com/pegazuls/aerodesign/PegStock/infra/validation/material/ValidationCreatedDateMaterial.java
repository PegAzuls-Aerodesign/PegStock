package com.pegazuls.aerodesign.PegStock.infra.validation.material;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;

@Component
public class ValidationCreatedDateMaterial implements ValidationMaterial {

    @Override
    public void validate(Material material) {
        // Verify if the created date is valid
        if (material.getCreatedDate() != null && material.getCreatedDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Data de fabricação inválida");
        }
    }

}
