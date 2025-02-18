package com.pegazuls.aerodesign.PegStock;

import com.pegazuls.aerodesign.PegStock.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PegStockApplication implements CommandLineRunner {

	@Autowired
	private Principal principal;

	public static void main(String[] args) {
		SpringApplication.run(PegStockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.teste();
	}
}
