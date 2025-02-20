package com.pegazuls.aerodesign.PegStock.infra.validation.material;

import org.springframework.stereotype.Component;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;

@Component
public class ValidationLimitDescriptionMaterial implements ValidationMaterial {

    @Override
    public void validate(Material material) {
        // Verify if the description is valid
        if (material.getDescription().length() > 200) {
            throw new ValidationException("Limite de caracteres excedido");
        }
    }

}
