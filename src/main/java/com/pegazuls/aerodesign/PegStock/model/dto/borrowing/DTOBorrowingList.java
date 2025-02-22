package com.pegazuls.aerodesign.PegStock.model.dto.borrowing;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;

public record DTOBorrowingList(
        int quantity,
        String borrower,
        String expirationDate,
        String createdDate,
        String responsible,
        String material
) {
    public DTOBorrowingList(Borrowing borrowing) {
        this(borrowing.getQuantity(),
                borrowing.getBorrower(),
                borrowing.getExpirationDate().toString(),
                borrowing.getCreatedDate().toString(),
                borrowing.getResponsible(),
                borrowing.getMaterial().getName());
    }

    @Override
    public String toString() {
        return "quantity: " + quantity + ", borrower: " + borrower + ", expiration date: " + expirationDate + ", created date: " + createdDate + ", responsible: " + responsible + ", material: " + material;
    }
}
