package com.pegazuls.aerodesign.PegStock.commands;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AddCommand extends Command {


    private final MaterialService service;

    @Autowired
    public AddCommand(MaterialService service) {
        this.name = "Adicionar";
        this.service = service;
    }

    public void setParameters(Material material, int quantity) {
        this.material = material;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        material.setQuantity(material.getQuantity() + quantity);
        service.update(material, material.getCod());
    }
}
