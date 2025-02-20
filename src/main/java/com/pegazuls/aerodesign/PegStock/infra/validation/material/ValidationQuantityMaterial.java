package com.pegazuls.aerodesign.PegStock.infra.validation.material;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import org.springframework.stereotype.Component;

@Component
public class ValidationQuantityMaterial implements ValidationMaterial {

    @Override
    public void validate(Material material) {
        // Verify if the quantity is valid
        if(material.getQuantity() <= 0){
            throw new ValidationException("Quantidade inválida");
        }
    }
}
