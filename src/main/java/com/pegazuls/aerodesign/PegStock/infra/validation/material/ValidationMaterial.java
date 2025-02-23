package com.pegazuls.aerodesign.PegStock.infra.validation.material;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

public interface ValidationMaterial {
   
    public void validate(Material material);
}
