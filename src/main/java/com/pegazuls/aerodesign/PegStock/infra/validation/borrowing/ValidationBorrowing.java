package com.pegazuls.aerodesign.PegStock.infra.validation.borrowing;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import org.springframework.stereotype.Component;

@Component
public interface ValidationBorrowing {
    public void validate(Borrowing borrowing);
}
