package com.pegazuls.aerodesign.PegStock.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOBorrowingDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Table(name = "tb_borrowing")
@Entity(name = "Borrowing")
@Setter
@Getter
@AllArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String borrower;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private LocalDate createdDate;

    @Column(nullable = false)
    private boolean returned = false;

    @Column(nullable = false)
    private String responsible;

    @ManyToOne
    @JoinColumn(name = "material_cod")
    @JsonIgnore
    private Material material;

    public Borrowing() {
        this.createdDate = LocalDate.now();
    }

    public Borrowing(DTOBorrowingDetails expirationDate) {
        this.expirationDate = expirationDate.expirationDate();
    }
}
