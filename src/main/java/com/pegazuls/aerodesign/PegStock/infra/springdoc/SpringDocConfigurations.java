package com.pegazuls.aerodesign.PegStock.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("PegStock API")
                        .version("1.0")
                        .description("API desenvolvida para o sistema PegStock, sistema de geranciamento de controle de bens da equipe Pegazuls.")
                        .contact( new Contact()
                                .name("PegAzuls Aerodesign")
                                .email("pegazuls@ufersa.edu.br")));
    }
}
