package com.pegazuls.aerodesign.PegStock.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "executed_commands")
@Getter
@Setter
@NoArgsConstructor
public class CommandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commandName;
    private int quantity;
    private String materialName;
    private LocalDate executedAt;

    public CommandEntity(String commandName, int quantity, String materialName) {
        this.commandName = commandName;
        this.quantity = quantity;
        this.materialName = materialName;
        this.executedAt = LocalDate.now();
    }

}
