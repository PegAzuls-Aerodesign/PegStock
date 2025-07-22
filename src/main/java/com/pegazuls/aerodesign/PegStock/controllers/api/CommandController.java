package com.pegazuls.aerodesign.PegStock.controllers.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands")
@Tag(name = "Comandos", description = "Controller para o gerenciamento dos comandos do sistema PegStock")
public class CommandController {

    @Autowired
    
}
