package com.pegazuls.aerodesign.PegStock.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

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
    private ImageView imageView;

    @FXML
    private TextField registerCod;

    @FXML
    private TextField registerName;

    @FXML
    private TextField registerQuantity;

    @FXML
    private TextField registerDescription;

    @FXML
    private DatePicker registerCreatedDate;

    @FXML
    private DatePicker registerExpirationDate;

    @FXML
    private ChoiceBox<Category> registerCategory;

    @FXML
    private ChoiceBox<Box> registerBox;

    @FXML
    private AnchorPane registerStockPage;

    @FXML
    private AnchorPane registerStockPageBackground;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configura as colunas da tabela
        productColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        cabinetColumn.setCellValueFactory(new PropertyValueFactory<>("box"));
        expiryColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));

        // Carrega os materiais na tabela
        loadMaterials();

        // Configura as opções dos ChoiceBox
        registerCategory.setItems(FXCollections.observableArrayList(Category.values()));
        registerBox.setItems(FXCollections.observableArrayList(Box.values()));
    }

    private void loadMaterials() {
        List<Material> materials = materialService.findAll();
        materialTable.getItems().setAll(materials);
    }

    @FXML
    void showRegisterStockPage(MouseEvent event) {
        registerStockPageBackground.setVisible(true);
        registerStockPage.setVisible(true);
    }

    @FXML
    void registerMaterial(MouseEvent event) {
        String name = registerName.getText();
        Long cod = Long.parseLong(registerCod.getText());
        int quantity = Integer.parseInt(registerQuantity.getText());
        String description = registerDescription.getText();
        LocalDate createdDate = registerCreatedDate.getValue();
        LocalDate expirationDate = registerExpirationDate.getValue();
        Category category = registerCategory.getValue();
        Box box = registerBox.getValue();

        Material material = new Material();
        material.setName(name);
        material.setCod(cod);
        material.setQuantity(quantity);
        material.setDescription(description);
        material.setCreatedDate(createdDate);
        material.setExpirationDate(expirationDate);
        material.setCategory(category);
        material.setBox(box);

        materialService.create(material);

        // Update the table
        loadMaterials();

        // Close the registration form
        registerStockPageBackground.setVisible(false);
        registerStockPage.setVisible(false);

        clearForm();
    }

    private void clearForm() {
        registerName.clear();
        registerCod.clear();
        registerQuantity.clear();
        registerDescription.clear();
        registerCreatedDate.setValue(null);
        registerExpirationDate.setValue(null);
        registerCategory.setValue(null);
        registerBox.setValue(null);
    }

    @FXML
    void cancelRegister(MouseEvent event) {
        registerStockPageBackground.setVisible(false);
        registerStockPage.setVisible(false);
        clearForm();
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
}