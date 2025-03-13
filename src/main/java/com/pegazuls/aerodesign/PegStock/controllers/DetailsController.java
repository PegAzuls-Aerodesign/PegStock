package com.pegazuls.aerodesign.PegStock.controllers;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import front.ScreenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class DetailsController implements Initializable {

    private Material material;

    @Autowired
    private ScreenManager screenManager;

    @FXML
    private Button buttonAdd, buttonBorrowing, buttonCancel, buttonConsumption, buttonCancelAdd;
  
    @FXML
    private Button buttonCancelConsume, buttonConfirmAdd, buttonConfirmConsume, buttonCancelBorrowing, buttonConfirmBorrowing;
  

    @FXML
    private Text code, dateAdd, dateConsumption, dateCriation, description,
            nameBox, nameCategory, nameTitle, nameValid, quantity,
            totalConsumption;
  
    @FXML
    private AnchorPane registerBackgroundPage, registerConsumePage, registerAddPage, registerBorrowingPage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (material != null) {
            updateUi();
        }
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
  
    public void showDetails(Material material) {
        this.material = material;
        System.out.println(material);
        screenManager.changeScreen("/front/fxml/DetailsPage.fxml");
    }

    private void updateUi() {
        if (material != null && nameTitle != null) { // Verifica se os elementos foram carregados
            nameTitle.setText(material.getName());
            code.setText(material.getCod().toString());
            description.setText(material.getDescription());
            nameCategory.setText(material.getCategory().toString());
            nameBox.setText(material.getBox().toString());
            quantity.setText(String.valueOf(material.getQuantity()));
            nameValid.setText(material.getExpirationDate().toString());
            dateCriation.setText(material.getCreatedDate().toString());
            totalConsumption.setText(String.valueOf(material.getConsumerQuantity()));
        }
    }

    @FXML
    void cancel(MouseEvent event) {}
  
    @FXML
    void confirm(MouseEvent event) {}
}
