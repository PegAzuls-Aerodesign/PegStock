package com.pegazuls.aerodesign.PegStock.infra.validation.material;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;

@Component
public class ValidationExpirationDateMaterial implements ValidationMaterial {

    @Override
    public void validate(Material material) {
        // Verify if the expiration date is valid
        if (material.getExpirationDate().isBefore(LocalDate.now())) {
            throw new ValidationException("Data de validade inválida");
        }
    }

}
