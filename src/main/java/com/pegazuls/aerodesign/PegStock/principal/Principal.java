package com.pegazuls.aerodesign.PegStock.principal;

import com.pegazuls.aerodesign.PegStock.model.dto.DTOBorrowingDetails;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.stereotype.Component;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.*;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;

import java.time.LocalDate;
import java.util.List;

@Component
public class Principal {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private BorrowingService borrowingService;
    @Autowired
    private ProjectInfoAutoConfiguration projectInfoAutoConfiguration;

    public void teste() {
        // Create a new material
        Material material1 = new Material(
                null, // cod
                "Material Name", // name
                "Material Description", // description
                100, // quantity
                Category.CONSUMIVEIS, // category
                Box.ARMARIO4, // box
                LocalDate.of(2025, 12, 31), // expirationDate
                LocalDate.of(2023, 1, 1), // createdDate
                LocalDate.now(), // registerDate
                null
        );

        Material material2 = new Material(
                null, // cod
                "Another Material Name", // name
                "Another Material Description", // description
                50, // quantity
                Category.NAO_CONSUMIVEIS, // category
                Box.ESTANTE, // box
                LocalDate.of(2024, 12, 31), // expirationDate
                LocalDate.of(2022, 6, 15), // createdDate
                LocalDate.now(), // registerDate
                null
        );


        // Save
        material1 = materialService.create(material1);
        material2 = materialService.create(material2);


        Borrowing borrowing1 = new Borrowing(
                null, // cod
                10, // quantity
                "Borrower 1", // borrower
                LocalDate.of(2022, 12, 31), // expirationDate
                LocalDate.now(), // createdDate
                material1
        );

        Borrowing borrowing2 = new Borrowing(
                null, // cod
                5, // quantity
                "Borrower 2", // borrower
                LocalDate.of(2023, 12, 31), // expirationDate
                LocalDate.now(), // createdDate
                material2
        );

        Borrowing borrowing3 = new Borrowing(
                null, // cod
                5, // quantity
                "Pra deletar", // borrower
                LocalDate.of(2023, 12, 31), // expirationDate
                LocalDate.now(), // createdDate
                material2
        );

        borrowing1 = borrowingService.create(material1.getCod(), borrowing1);
        borrowing2 = borrowingService.create(material2.getCod(), borrowing2);
        borrowing3 = borrowingService.create(material2.getCod(), borrowing3);

        // Listar os emprestimos do material 2

        List<DTOBorrowingDetails> borrowings = materialService.getBorrowings(material2.getCod());

        System.out.println("Borrowings of material 2: ");
        for (DTOBorrowingDetails borrowing : borrowings) {
            System.out.println(borrowing.expirationDate());
        }

        // find by id


        // Find all

        List<Borrowing> borrowingsList = borrowingService.findAll();
        System.out.println("All borrowings: ");
        for (Borrowing borrowing : borrowingsList) {
            System.out.println(borrowing.getBorrower());
        }

        // Update
        borrowing2.setExpirationDate(LocalDate.of(2025, 12, 31));
        borrowingService.update(borrowing2.getCod(), borrowing2);
        System.out.println("Borrowing 2: " + borrowing2.getExpirationDate());



        System.out.println(borrowing3.getCod());
        borrowingService.delete(borrowing3.getCod());
        System.out.println("Borrowing deleted");

    }
}