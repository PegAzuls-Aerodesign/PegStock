package com.pegazuls.aerodesign.PegStock.infra.validation.borrowing;

import com.pegazuls.aerodesign.PegStock.infra.exceptions.ValidationException;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidationBorrowingExpirationDate implements ValidationBorrowing {

    @Override
    public void validate(Borrowing borrowing) {
        // Verificar se a data de expiração é válida
        if(borrowing.getExpirationDate().isBefore(LocalDate.now())){
            throw new ValidationException("Data de expiração inválida!!! A data de expiração não pode ser antes da data de início");
        }
    }
}
