package com.pegazuls.aerodesign.PegStock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"front", "com.pegazuls.aerodesign.PegStock"})
public class PegStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(PegStockApplication.class, args);
    }
}