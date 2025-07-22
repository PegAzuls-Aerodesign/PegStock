package com.pegazuls.aerodesign.PegStock.infra.validation.shopping_list;

import org.springframework.stereotype.Component;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;

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
