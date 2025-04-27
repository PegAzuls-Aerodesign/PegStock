package com.pegazuls.aerodesign.PegStock.model.dto.borrowing;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;

import java.time.LocalDate;

public record DTOCreateBorrowing(
        Long materialCod,
        LocalDate expirationDate,
        int quantity,
        String borrower,
        String responsible
) {
    public Borrowing toBorrowing() {
        return new Borrowing(
                null,
                quantity,
                borrower,
                expirationDate,
                LocalDate.now(),
                false,
                responsible,
                null
        );
    }
}
