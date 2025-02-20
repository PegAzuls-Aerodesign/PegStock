package com.pegazuls.aerodesign.PegStock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pegazuls.aerodesign.PegStock.principal.Principal;

@SpringBootApplication
public class PegStockApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PegStockApplication.class, args);
	}

	@Autowired
	private Principal principal;
	
	@Override
	public void run(String... args) throws Exception {
		principal.teste();
	}

}
