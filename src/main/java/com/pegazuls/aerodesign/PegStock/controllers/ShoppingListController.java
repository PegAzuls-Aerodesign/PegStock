package com.pegazuls.aerodesign.PegStock.controllers;

import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import com.pegazuls.aerodesign.PegStock.service.ShoppingListService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ShoppingListController implements Initializable {

    @Autowired
    private ShoppingListService service;

    @FXML
    private Button buttonRegisterBuyList;

    @FXML
    private Button buttonGenerateShoppingList;

    @FXML
    private AnchorPane registerBuyListPage;

    @FXML
    private AnchorPane registerBuyListPageBackground;

    @FXML
    private AnchorPane buyListPage;

    @FXML
    private TableView<ShoppingList> buyListTable;

    @FXML
    private TableColumn<ShoppingList, String> productNameColumn;

    @FXML
    private TableColumn<ShoppingList, Integer> quantityColumn;

    @FXML
    private TableColumn<ShoppingList, Double> priceColumn;

    @FXML
    private TableColumn<ShoppingList, String> supplierColumn;

    @FXML
    private TableColumn<ShoppingList, String> linkColumn;


    @FXML
    private TableColumn<ShoppingList, Void> actionsColumn;

    @FXML
    private TextField productName;

    @FXML
    private TextField quantity;

    @FXML
    private TextField unityPrice;

    @FXML
    private TextField supplier;

    @FXML
    private TextField link;

    @FXML
    private TextField description;

    private ShoppingList current;



    private void loadShoppingList() {
        // Carrega a lista de compras
        List<ShoppingList> shoppingDetailsList = service.findAll();
        buyListTable.getItems().setAll(shoppingDetailsList);

    }

    @FXML
    void showBuyListPage(MouseEvent event) {
        registerBuyListPage.setVisible(true);
        registerBuyListPageBackground.setVisible(true);
    }

    @FXML
    void generateShoppingList(MouseEvent event) {
        // Gera a lista de compras
        service.generateShoppingListCSV();
    }

    @FXML
    void registerShoppingList(MouseEvent event) {
        try {
            if (current == null){
                ShoppingList shoppingList = new ShoppingList();
                shoppingList.setProductName(productName.getText());
                shoppingList.setQuantity(Integer.parseInt(quantity.getText()));
                shoppingList.setPrice(Double.parseDouble(unityPrice.getText()));
                shoppingList.setSupplier(supplier.getText());
                shoppingList.setLink(link.getText());
                shoppingList.setDescription(description.getText());
                shoppingList.setDate(LocalDate.now());
                shoppingList.setTotalValue(shoppingList.getPrice() * shoppingList.getQuantity());

                service.create(shoppingList);
            } else {
                current.setProductName(productName.getText());
                current.setQuantity(Integer.parseInt(quantity.getText()));
                current.setPrice(Double.parseDouble(unityPrice.getText()));
                current.setSupplier(supplier.getText());
                current.setLink(link.getText());
                current.setDescription(description.getText());

                service.update(current.getCod(), current);
            }

            loadShoppingList();
            registerBuyListPage.setVisible(false);
            registerBuyListPageBackground.setVisible(false);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao registrar produto na lista de compras");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void editShoppingList(ShoppingList shoppingList) {
        try {
            current = service.findById(shoppingList.getCod());

            productName.setText(shoppingList.getProductName());
            quantity.setText(String.valueOf(shoppingList.getQuantity()));
            unityPrice.setText(String.valueOf(shoppingList.getPrice()));
            supplier.setText(shoppingList.getSupplier());
            link.setText(shoppingList.getLink());
            description.setText(shoppingList.getDescription());

            registerBuyListPage.setVisible(true);
            registerBuyListPageBackground.setVisible(true);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao registrar a lista de compras");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void deleteShoppingList(ShoppingList shoppingList) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("PegStock");
        alert.setHeaderText("Tem certeza que deseja excluir o material " + shoppingList.getProductName() + "?");
        alert.setContentText("Essa ação não poderá ser desfeita.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                service.delete(shoppingList.getCod());
                loadShoppingList();
            }
        });
    }

    private void clearForm() {
        productName.clear();
        quantity.clear();
        unityPrice.clear();
        supplier.clear();
        link.clear();
        description.clear();
    }

    @FXML
    void cancelRegister(MouseEvent event) {
        registerBuyListPage.setVisible(false);
        registerBuyListPageBackground.setVisible(false);
        clearForm();
    }


    @FXML
    void showRegisterBuyListPage(MouseEvent event) {
        registerBuyListPage.setVisible(true);
        registerBuyListPageBackground.setVisible(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        supplierColumn.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        linkColumn.setCellValueFactory(new PropertyValueFactory<>("link"));


        loadShoppingList();

        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Editar");
            private final Button deleteButton = new Button("Excluir");

            private final HBox pane = new HBox(editButton, deleteButton);

            {
                pane.setSpacing(10);

                editButton.setOnAction(event -> {
                    ShoppingList shoppingList = getTableView().getItems().get(getIndex());
                    editShoppingList(shoppingList);
                });

                deleteButton.setOnAction(event -> {
                    ShoppingList shoppingList = getTableView().getItems().get(getIndex());
                    deleteShoppingList(shoppingList);
                });
            }

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
}
