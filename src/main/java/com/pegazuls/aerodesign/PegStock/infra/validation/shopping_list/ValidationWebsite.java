package com.pegazuls.aerodesign.PegStock.infra.validation.shopping_list;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidationWebsite implements ValidationCreateSL {

    private static final String URL_REGEX =
            "^(https?://)?([\\w\\-]+\\.)+\\w{2,}(:\\d{1,5})?(/.*)?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX, Pattern.CASE_INSENSITIVE);


    @Override
    public void validate(ShoppingList shoppingList) {
        // Verificar se o link é válido
        if(!URL_PATTERN.matcher(shoppingList.getLink()).matches()){
            throw new ValidationException("Link inválido");
        }

    }
}