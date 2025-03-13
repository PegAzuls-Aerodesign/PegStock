package com.pegazuls.aerodesign.PegStock.controllers;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    private Button buttonAdd, buttonBorrowing, buttonCancel, buttonConsumption;

    @FXML
    private Text code, dateAdd, dateConsumption, dateCriation, description,
            nameBox, nameCategory, nameTitle, nameValid, quantity,
            totalAdd, totalConsumption;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (material != null) {
            updateUi();
        }
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
    void add(MouseEvent event) {}

    @FXML
    void borrowingPage(MouseEvent event) {}

    @FXML
    void cancel(MouseEvent event) {}

    @FXML
    void consumption(MouseEvent event) {}
}
