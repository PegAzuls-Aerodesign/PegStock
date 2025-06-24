package com.pegazuls.aerodesign.PegStock.model.dto.borrowing;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;

public record DTOBorrowingList(
        Long cod,
        int quantity,
        String borrower,
        String expirationDate,
        String createdDate,
        String responsible,
        String material,
        boolean returned
) {
    public DTOBorrowingList(Borrowing borrowing) {
        this(borrowing.getCod(),
                borrowing.getQuantity(),
                borrowing.getBorrower(),
                borrowing.getExpirationDate().toString(),
                borrowing.getCreatedDate().toString(),
                borrowing.getResponsible(),
                borrowing.getMaterial().getName(),
                borrowing.isReturned());
    }

    @Override
    public String toString() {
        return "quantity: " + quantity + ", borrower: " + borrower + ", expiration date: " + expirationDate + ", created date: " + createdDate + ", responsible: " + responsible + ", material: " + material;
    }
}
