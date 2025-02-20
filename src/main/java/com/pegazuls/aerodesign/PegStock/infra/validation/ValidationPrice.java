package com.pegazuls.aerodesign.PegStock.infra.validation;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import org.springframework.stereotype.Component;

@Component
public class ValidationPrice implements ValidationCreateSL {

    @Override
    public void validate(ShoppingList shoppingList) {
        // Verificar se o preço é válido
        if(shoppingList.getPrice() <= 0){
            throw new ValidationException("Preço inválido!!! Você obviamente não vai pagar para alguém te dar algo");
        }
    }
}
