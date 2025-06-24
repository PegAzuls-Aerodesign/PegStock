package com.pegazuls.aerodesign.PegStock.model.dto.authentication;

import jakarta.validation.constraints.NotBlank;

public record DTOLogin(

        @NotBlank
        String email,

        @NotBlank
        String password
) {
}
