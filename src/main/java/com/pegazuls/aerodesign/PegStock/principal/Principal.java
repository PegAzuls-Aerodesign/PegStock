package com.pegazuls.aerodesign.PegStock.principal;

import com.pegazuls.aerodesign.PegStock.commands.AddCommand;
import com.pegazuls.aerodesign.PegStock.commands.CommandInvoker;
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

    public void teste() {

//        Material material = service.findById(3L);
//        addCommand.setParameters(material, 10);

        invoker.generateReport();

    }
}