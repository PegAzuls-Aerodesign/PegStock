package com.pegazuls.aerodesign.PegStock.controllers;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import front.ScreenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DetailsController {

    private Material material;

    @Autowired
    private ScreenManager screenManager;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonBorrowing;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonConsumption;

    @FXML
    private Text code;

    @FXML
    private Text dateAdd;

    @FXML
    private Text dateConsumption;

    @FXML
    private Text dateCriation;

    @FXML
    private Text description;

    @FXML
    private Text nameBox;

    @FXML
    private Text nameCategory;

    @FXML
    private Text nameTitle;

    @FXML
    private Text nameValid;

    @FXML
    private Text quantity;

    @FXML
    private Text totalAdd;

    @FXML
    private Text totalConsumption;

    public void showDetails(Material material) {
        this.material = material;
        System.out.println(material);
        screenManager.changeScreen("/front/fxml/DetailsPage.fxml");
    }



    @FXML
    void add(MouseEvent event) {

    }

    @FXML
    void borrowingPage(MouseEvent event) {

    }

    @FXML
    void cancel(MouseEvent event) {

    }

    @FXML
    void consumption(MouseEvent event) {

    }

}
