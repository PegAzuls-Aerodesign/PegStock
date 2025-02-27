package com.pegazuls.aerodesign.PegStock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.pegazuls.aerodesign.PegStock.principal.Principal;

import front.PegStockFront;
import javafx.application.Application;

@EnableScheduling
@SpringBootApplication
public class PegStockApplication implements CommandLineRunner {

    public static void main(String[] args) {
        Application.launch(PegStockFront.class, args);
    }

    @Autowired
    private Principal principal;
    
    @Override
    public void run(String... args) throws Exception {
        principal.teste();
    }

}
