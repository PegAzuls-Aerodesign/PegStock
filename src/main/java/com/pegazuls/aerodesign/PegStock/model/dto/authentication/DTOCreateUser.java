package com.pegazuls.aerodesign.PegStock.model.dto.authentication;

import jakarta.validation.constraints.NotBlank;

public record DTOCreateUser(

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String password
) {
}
