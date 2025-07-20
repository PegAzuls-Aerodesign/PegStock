package com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary;

public class DTOMonthlySummary {

    private String month;
    private Double totalConsumption;
    private Double totalAddition;

    // Construtor para facilitar a criação na consulta JPQL
    public DTOMonthlySummary(int year, int month, Double totalConsumption, Double totalAddition) {
        this.month = String.format("%d-%02d", year, month);
        this.totalConsumption = totalConsumption;
        this.totalAddition = totalAddition;
    }
}
