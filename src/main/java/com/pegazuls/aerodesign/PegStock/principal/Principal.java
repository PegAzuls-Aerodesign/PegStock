package com.pegazuls.aerodesign.PegStock.principal;

import com.pegazuls.aerodesign.PegStock.commands.AddCommand;
import com.pegazuls.aerodesign.PegStock.commands.CommandInvoker;
import com.pegazuls.aerodesign.PegStock.commands.ConsumeCommand;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Principal {

    @Autowired
    private CommandInvoker invoker;

    @Autowired
    private MaterialService service;

    @Autowired
    private AddCommand addCommand;

    @Autowired
    private ConsumeCommand consumeCommand;

    public void teste() {

//        Material material = service.findById(9L);
//        consumeCommand.setParameters(material, 10);
//
//        Material material2 = service.findById(6L);
//        addCommand.setParameters(material2, 10);
//
//        invoker.execute(consumeCommand);
//        invoker.execute(addCommand);
//
//        Material material3 = service.findById(6L);
//        addCommand.setParameters(material3, 10);
//        invoker.execute(addCommand);
//
//        Material material4 = service.findById(3L);
//        consumeCommand.setParameters(material4, 50);
//        invoker.execute(consumeCommand);

        invoker.generateReport();

    }
}