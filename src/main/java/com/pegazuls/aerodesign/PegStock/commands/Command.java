package com.pegazuls.aerodesign.PegStock.commands;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import lombok.Getter;

@Getter
public abstract class Command {

    protected String name;
    protected int quantity;
    protected Material material;

    public abstract void execute();

}
