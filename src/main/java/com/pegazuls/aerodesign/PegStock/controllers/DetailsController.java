package com.pegazuls.aerodesign.PegStock.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class DetailsController {

    @FXML
    private Button buttonAdd, buttonBorrowing, buttonCancel, buttonConsumption, confirm, buttonCancelAdd;

    @FXML
    private Button buttonCancelConsume, buttonConfirmAdd, buttonConfirmConsume, buttonCancelBorrowing, buttonConfirmBorrowing;

    @FXML
    private Text code, dateAdd, dateConsumption, dateCriation, description, nameBox, nameCategory;

    @FXML
    private Text nameTitle, nameValid, quantity, totalConsumption;

    @FXML
    private AnchorPane registerBackgroundPage, registerConsumePage, registerAddPage, registerBorrowingPage;

    @FXML
    void cancel(MouseEvent event) {

    }

    @FXML
    void confirm(MouseEvent event) {

    }

    @FXML
    void showRegisterConsumePage(MouseEvent event) {
        registerBackgroundPage.setVisible(true);
        registerConsumePage.setVisible(true);
    }

    @FXML
        void showRegisterAddPage(MouseEvent event) {
        registerBackgroundPage.setVisible(true);
        registerAddPage.setVisible(true);
    }

    @FXML
    void showRegisterBorrowingPage(MouseEvent event) {
        registerBackgroundPage.setVisible(true);
        registerBorrowingPage.setVisible(true);
    }

}
