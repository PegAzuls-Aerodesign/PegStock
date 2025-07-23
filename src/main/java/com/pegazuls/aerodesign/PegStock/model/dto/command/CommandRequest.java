package com.pegazuls.aerodesign.PegStock.model.dto.command;

public class CommandRequest {
    private Long materialCod;
    private int quantity;

    public Long getMaterialCod() {
        return materialCod;
    }

    public void setMaterialCod(Long materialCod) {
        this.materialCod = materialCod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
