package com.pegazuls.aerodesign.PegStock.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import front.main.ScreenManager;

import java.io.IOException;
import java.net.URL;

@Controller
public class PegStockController {

    @FXML
    private Button buttonBuyList;

    @FXML
    private Button buttonDashboard;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonLoan;

    @FXML
    private Button buttonStock;

    @FXML
    private Text nameOut;

    @FXML
    private Pane contentPane;

    @Autowired
    private ScreenManager screenManager;

    @FXML
    void pages(MouseEvent event) {
        if (event.getSource() == buttonHome) {
            nameOut.setText(buttonHome.getText());
        } else if (event.getSource() == buttonDashboard) {
            nameOut.setText(buttonDashboard.getText());
        } else if (event.getSource() == buttonStock) {
            nameOut.setText(buttonStock.getText());
            showStock();
        } else if (event.getSource() == buttonBuyList) {
            nameOut.setText(buttonBuyList.getText());
            showShoppingList();
        } else if (event.getSource() == buttonLoan) {
            nameOut.setText(buttonLoan.getText());
        }
    }

    public void showStock() {
        screenManager.changeScreen("/front/fxml/StockPage.fxml");
    }

    public void showShoppingList() {
        screenManager.changeScreen("/front/fxml/ShoppingListPage.fxml");
    }
}