package com.pegazuls.aerodesign.PegStock.commands;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BorrowCommand extends Command {

    @Autowired
    private final BorrowingService service;
    private Borrowing borrowing;

    public BorrowCommand(BorrowingService service) {
        this.name = "Borrow";
        this.service = service;
    }

    public void setParameters(Material material, Borrowing borrowing) {
        this.material = material;
        this.borrowing = borrowing;
    }

    @Override
    public void execute() {
        service.create(material.getCod(), borrowing);
    }
}
