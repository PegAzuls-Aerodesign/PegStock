package com.pegazuls.aerodesign.PegStock.commands;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConsumeCommand extends Command {


    @Autowired
    private final MaterialService service;

    public ConsumeCommand(MaterialService service) {
        this.name = "Consumir";
        this.service = service;
    }

    public void setParameters(Material material, int quantity) {
        this.material = material;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        material.setQuantity(material.getQuantity() - quantity);
        service.update(material, material.getCod());
    }
}
