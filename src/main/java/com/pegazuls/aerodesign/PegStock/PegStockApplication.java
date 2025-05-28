package com.pegazuls.aerodesign.PegStock;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "PegStock API",
                version = "1.0",
                description = "API desenvolvida para o sistema PegStock, sistema de geranciamento de controle de bens da equipe Pegazuls."
        )
)
@ComponentScan(basePackages = {"front", "com.pegazuls.aerodesign.PegStock"})
public class PegStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(PegStockApplication.class, args);
    }
}