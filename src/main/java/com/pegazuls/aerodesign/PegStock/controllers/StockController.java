package com.pegazuls.aerodesign.PegStock.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;

@Controller
public class StockController implements Initializable {

    @Autowired
    private MaterialService materialService;

    @FXML
    private TableView<Material> materialTable;

    @FXML
    private TableColumn<Material, String> productColumn;

    @FXML
    private TableColumn<Material, Integer> quantityColumn;

    @FXML
    private TableColumn<Material, Category> categoryColumn;

    @FXML
    private TableColumn<Material, Box> cabinetColumn;

    @FXML
    private TableColumn<Material, LocalDate> expiryColumn;

    @FXML
    private Button buttonBuyList;

    @FXML
    private Button buttonDashboard;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonLoan;

    @FXML
    private Button buttonNavigate;

    @FXML
    private Button buttonRegisterBuyList;

    @FXML
    private Button buttonRegisterStock;

    @FXML
    private Button buttonStock;

    @FXML
    private ImageView imageView;

    @FXML
    private Text nameOut;

    @FXML
    private AnchorPane registerStockPage;

    @FXML
    private AnchorPane registerStockPageBackground;

    @FXML
    private AnchorPane stockPage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        cabinetColumn.setCellValueFactory(new PropertyValueFactory<>("box"));
        expiryColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));

        if (materialService != null) {
            System.out.println("MaterialService is not null");
            loadMaterials();
        } else {
            System.out.println("MaterialService is null");
        }
    }

    private void loadMaterials() {
        List<Material> materials = materialService.findAll();
        materialTable.getItems().setAll(materials);
    }

    @FXML
    void selectImage(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }

    @FXML
    void showRegisterStockPage(MouseEvent event) {
        buttonRegisterStock.setOnMouseClicked(event1 -> registerStockPageBackground.setVisible(true));
        buttonRegisterStock.addEventHandler(MouseEvent.MOUSE_CLICKED, event1 -> registerStockPage.setVisible(true));
    }
}
