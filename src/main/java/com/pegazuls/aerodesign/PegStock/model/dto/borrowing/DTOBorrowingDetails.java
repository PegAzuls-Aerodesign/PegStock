package com.pegazuls.aerodesign.PegStock.model.dto.borrowing;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;

import java.time.LocalDate;

public record DTOBorrowingDetails(
        LocalDate expirationDate
) {
    public DTOBorrowingDetails(Borrowing borrowing) {
        this(borrowing.getExpirationDate());
    }

    @Override
    public String toString() {
        return "expiration date: " + expirationDate;
    }
}