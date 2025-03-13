package com.pegazuls.aerodesign.PegStock.infra.validation.shopping_list;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.infra.validation.shopping_list.ValidationCreateSL;
import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import org.springframework.stereotype.Component;

@Component
public class ValidationQuantity implements ValidationCreateSL {

    @Override
    public void validate(ShoppingList shoppingList) {
        // Verificar se a quantidade é válida
        if(shoppingList.getQuantity() <= 0){
            throw new ValidationException("Quantidade inválida!!! Especifique uma quantidade maior que 0");
        }
    }
}
