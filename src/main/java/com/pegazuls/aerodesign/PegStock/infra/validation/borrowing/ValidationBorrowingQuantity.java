package com.pegazuls.aerodesign.PegStock.infra.validation.borrowing;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import org.springframework.stereotype.Component;

@Component
public class ValidationBorrowingQuantity implements ValidationBorrowing {

    @Override
    public void validate(Borrowing borrowing) {
        // Verificar se a quantidade é válida
        if(borrowing.getQuantity() > borrowing.getMaterial().getQuantity()){
            throw new ValidationException("Quantidade inválida!!! Você não pode pegar uma quantidade negativa de itens");
        }
    }
}
