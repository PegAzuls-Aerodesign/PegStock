package com.pegazuls.aerodesign.PegStock.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Table(name = "tb_borrowing")
@Entity(name = "Borrowing")
@Setter
@Getter
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

    @ManyToOne
    @JoinColumn(name = "material_cod")
    private Material material;

    public Borrowing(Long cod, int quantity, String borrower, LocalDate expirationDate, Material material) {
        this.cod = cod;
        this.quantity = quantity;
        this.borrower = borrower;
        this.expirationDate = expirationDate;
        this.createdDate = LocalDate.now();
        this.material = material;
        this.returned = false;
    }

    public Borrowing() {
        this.createdDate = LocalDate.now();
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
