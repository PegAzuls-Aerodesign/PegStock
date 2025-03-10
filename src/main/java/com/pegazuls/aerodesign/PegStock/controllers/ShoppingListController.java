package com.pegazuls.aerodesign.PegStock.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ShoppingListController {

    @FXML
    private Button buttonRegisterBuyList;

    @FXML
    private AnchorPane registerBuyListPage;

    @FXML
    private AnchorPane registerBuyListPageBackground;

    @FXML
    private AnchorPane buyListPage;

    @FXML
    void showRegisterBuyListPage(MouseEvent event) {
        // Exibe a página de lista de compras
        buttonRegisterBuyList.setOnMouseClicked(event1 -> registerBuyListPageBackground.setVisible(true));
        buttonRegisterBuyList.addEventHandler(MouseEvent.MOUSE_CLICKED, event1 -> registerBuyListPage.setVisible(true));

    }
}
