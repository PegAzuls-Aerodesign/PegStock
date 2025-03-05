package com.pegazuls.aerodesign.PegStock.commands;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Getter
public class ConsumeCommand extends Command {


    @Autowired
    private MaterialService service;


    public ConsumeCommand(Material material, int quantity) {
        this.name = "Consumir";
        this.material = material;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        material.setQuantity(material.getQuantity() - quantity);
        service.update(material, material.getCod());
    }
}
