package com.pegazuls.aerodesign.PegStock.model.entities;

import com.pegazuls.aerodesign.PegStock.model.enums.MovementType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_stock_movement")
@Getter
@Setter
@NoArgsConstructor
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "material_cod")
    private Material material;

    @Column(nullable = false)
    private int quantity; // Quantidade movimentada

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType type; // ADDITION, CONSUMPTION, RETURN, ADJUSTMENT

    @Column(nullable = false)
    private LocalDate movementDate;

    @Column(nullable = false)
    private String responsible; // Responsável pela movimentação

    public StockMovement(Material material, int quantity, MovementType type, String responsible, LocalDate movementDate) {
        this.material = material;
        this.quantity = quantity;
        this.type = type;
        if (movementDate == null)
            this.movementDate = LocalDate.now();
        else
            this.movementDate = movementDate;
        this.responsible = responsible;
    }
}
