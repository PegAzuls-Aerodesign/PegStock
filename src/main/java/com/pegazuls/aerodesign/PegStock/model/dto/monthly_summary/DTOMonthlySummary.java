package com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary;

public class DTOMonthlySummary {

    private String month;
    private Long totalConsumption;
    private Long totalAddition;


    public DTOMonthlySummary(Integer year, Integer month, Long totalConsumption, Long totalAddition) {
        // Formata o mês para o padrão "YYYY-MM" para o front-end
        this.month = String.format("%d-%02d", year, month);


        this.totalConsumption = (totalConsumption != null) ? totalConsumption : 0L;
        this.totalAddition = (totalAddition != null) ? totalAddition : 0L;
    }

    // Getters
    public String getMonth() {
        return month;
    }

    public Long getTotalConsumption() {
        return totalConsumption;
    }

    public Long getTotalAddition() {
        return totalAddition;
    }
}