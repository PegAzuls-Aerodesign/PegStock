package com.pegazuls.aerodesign.PegStock.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import front.ScreenManager;

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

    @Autowired
    private ApplicationContext context;

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
            showLoan();
        }
    }

    public void loadScreen(String fxmlFile) {
        // Carrega a tela de acordo com o botão clicado
        try {
            URL fxmlLocation = getClass().getResource(fxmlFile);
            if (fxmlLocation == null) {
                throw new IllegalArgumentException("FXML file not found" + fxmlFile);
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            loader.setControllerFactory(context::getBean);

            Parent screen = loader.load();

            // Garante que a tela carregada preencha o contentPane
            AnchorPane.setTopAnchor(screen, 0.0);
            AnchorPane.setBottomAnchor(screen, 0.0);
            AnchorPane.setLeftAnchor(screen, 0.0);
            AnchorPane.setRightAnchor(screen, 0.0);

            contentPane.getChildren().setAll(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStock() {
        loadScreen("/front/fxml/StockPage.fxml");
    }
    public void showShoppingList() {
        loadScreen("/front/fxml/ShoppingListPage.fxml");
    }

    public void showLoan(){
        loadScreen("/front/fxml/LoanPage.fxml");
    }

    public void showDetails(){
        loadScreen("/front/fxml/DetailsPage.fxml");
    }
}