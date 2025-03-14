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
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.scene.layout.HBox;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;
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
    private DetailsController detailsController;

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
    private TableColumn<Material, Void> actionsColumn;

    @FXML
    private TableColumn<Material, Void> detailColumn;

    @FXML
    private ImageView imageView;

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

    private Material currentMaterial;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        materialTable.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.getStylesheets().add(getClass().getResource("/front/styles/centerDesign.css").toExternalForm());
            }
        });
        productColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        cabinetColumn.setCellValueFactory(new PropertyValueFactory<>("box"));
        expiryColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));

        loadMaterials();

        registerCategory.setItems(FXCollections.observableArrayList(Category.values()));
        registerBox.setItems(FXCollections.observableArrayList(Box.values()));

        // Actions column
        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Editar");
            private final Button deleteButton = new Button("Deletar");
            private final HBox pane = new HBox(editButton, deleteButton);

            {
                editButton.getStyleClass().add("button-standard");
                deleteButton.getStyleClass().add("button-cancel");

                pane.setSpacing(15);

                editButton.setOnAction(event -> {
                    Material material = getTableView().getItems().get(getIndex());
                    editMaterial(material);
                });

                deleteButton.setOnAction(event -> {
                    Material material = getTableView().getItems().get(getIndex());
                    deleteMaterial(material);
                });

            }

            // Display button if the row is not empty
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(pane);
                }
            }

        });

        // Detail column
        detailColumn.setCellFactory(param -> new TableCell<>() {
            private final Button detailButton = new Button();
            private final HBox pane = new HBox(detailButton);

            {
                FontIcon detailIcon = new FontIcon(FontAwesomeSolid.SEARCH);
                detailIcon.setIconSize(10);
                detailIcon.setIconColor(Paint.valueOf("#1258aa"));

                detailButton.setGraphic(detailIcon);
                detailButton.setStyle("-fx-background-color: transparent;");

                pane.setSpacing(0);

                detailButton.setOnAction(event -> {
                    Material material = getTableView().getItems().get(getIndex());
                    detailsController.showDetails(material);
                });

            }

            // Display button if the row is not empty
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(pane);
                }
            }

        });
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
        try {
            if (currentMaterial == null) {
                Material material = new Material();
                material.setName(registerName.getText());
                material.setQuantity(Integer.parseInt(registerQuantity.getText()));
                material.setDescription(registerDescription.getText());
                material.setCreatedDate(registerCreatedDate.getValue());
                material.setExpirationDate(registerExpirationDate.getValue());
                material.setCategory(registerCategory.getValue());
                material.setBox(registerBox.getValue());

                materialService.create(material);
            } else {
                currentMaterial.setName(registerName.getText());
                currentMaterial.setQuantity(Integer.parseInt(registerQuantity.getText()));
                currentMaterial.setDescription(registerDescription.getText());
                currentMaterial.setCreatedDate(registerCreatedDate.getValue());
                currentMaterial.setExpirationDate(registerExpirationDate.getValue());
                currentMaterial.setCategory(registerCategory.getValue());
                currentMaterial.setBox(registerBox.getValue());

                materialService.update(currentMaterial, currentMaterial.getCod());
            }

            loadMaterials();
            registerStockPageBackground.setVisible(false);
            registerStockPage.setVisible(false);

            clearForm();
        } catch (Exception e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro ao salvar o material.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void editMaterial(Material material) {

        currentMaterial = materialService.findById(material.getCod());

        registerName.setText(material.getName());
        registerQuantity.setText(String.valueOf(material.getQuantity()));
        registerDescription.setText(material.getDescription());
        registerCreatedDate.setValue(material.getCreatedDate());
        registerExpirationDate.setValue(material.getExpirationDate());
        registerCategory.setValue(material.getCategory());
        registerBox.setValue(material.getBox());

        registerStockPageBackground.setVisible(true);
        registerStockPage.setVisible(true);
    }

    private void deleteMaterial(Material material) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("PegStock");
        alert.setHeaderText("Tem certeza que deseja excluir o material " + material.getName() + "?");
        alert.setContentText("Essa ação não poderá ser desfeita.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                materialService.delete(material.getCod());
                loadMaterials();
            }
        });
    }

    private void clearForm() {
        registerName.clear();
        registerQuantity.clear();
        registerDescription.clear();
        registerCreatedDate.setValue(null);
        registerExpirationDate.setValue(null);
        registerCategory.setValue(null);
        registerBox.setValue(null);

        currentMaterial = null;
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
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }
}