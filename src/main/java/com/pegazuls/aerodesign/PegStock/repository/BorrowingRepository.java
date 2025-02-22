package com.pegazuls.aerodesign.PegStock.repository;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    // Método para buscar empréstimos que a data de expiração já passou e ainda não foram devolvidos
    List<Borrowing> findByExpirationDateBeforeAndReturnedFalse(LocalDate date);
}
