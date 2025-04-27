package com.pegazuls.aerodesign.PegStock.infra.validation.borrowing;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import org.springframework.stereotype.Component;

@Component
public class ValidationBorrowingNullMaterial implements ValidationBorrowing {

    @Override
    public void validate(Borrowing borrowing) {
        if (borrowing.getMaterial() == null) {
            throw new IllegalArgumentException("Material não encontrado");
        }
    }

}
