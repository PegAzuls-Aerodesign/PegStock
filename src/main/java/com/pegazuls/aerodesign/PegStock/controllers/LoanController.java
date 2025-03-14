package com.pegazuls.aerodesign.PegStock.controllers;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.BorrowingService;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Method;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class LoanController implements Initializable {

    @Autowired
    private BorrowingService borrowingService;

    @Autowired
    private MaterialService materialService;

    @FXML
    private Button buttonConfirmBorrowing, buttonRegisterStock;

    @FXML
    private TableColumn<Borrowing, Void> actionsColumn;

    @FXML
    private TableColumn<Borrowing, LocalDate> dateBorrowingColumn, dateDevolutionColumn;

    @FXML
    private TableColumn<Borrowing, String> materialColumn;

    @FXML
    private TableColumn<Borrowing, Integer> quantityColumn;

    @FXML
    private TableColumn<Borrowing, String> borrowerColumn;

    @FXML
    private TableColumn<Borrowing, String> responsibleColumn;

    @FXML
    private TableView<Borrowing> borrowingTable;

    @FXML
    private TableColumn<Borrowing, String> statusColumn;

    @FXML
    private TextField registerQuantity, registerBorrower, registerResponsible, registerMaterialId;

    @FXML
    private DatePicker registerDateDevolution;

    @FXML
    private AnchorPane registerBorrowingPage;

    @FXML
    private AnchorPane registerBorrowingPageBackground;

    private Borrowing currentBorrowing;

    private Material currentMaterial;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        borrowingTable.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.getStylesheets().add(getClass().getResource("/front/styles/centerDesign.css").toExternalForm());
            }
        });

        materialColumn.setCellValueFactory(new PropertyValueFactory<>("material"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateBorrowingColumn.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
        dateDevolutionColumn.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        borrowerColumn.setCellValueFactory(new PropertyValueFactory<>("borrower"));
        responsibleColumn.setCellValueFactory(new PropertyValueFactory<>("responsible"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("returned"));

        loadBorrowings();

        actionsColumn.setCellFactory(param -> new TableCell<>() {
            private final Button deleteButton = new Button("Deletar");
            private final Button statusButton = new Button("Devolvido");
            private final HBox pane = new HBox(statusButton, deleteButton);

            {
                statusButton.getStyleClass().add("button-standard");
                deleteButton.getStyleClass().add("button-cancel");

                pane.setSpacing(10);

                statusButton.setOnAction(event -> {
                    Borrowing borrowing = getTableView().getItems().get(getIndex());
                    changeStatus(borrowing);
                });

                deleteButton.setOnAction(event -> {
                    Borrowing borrowing = getTableView().getItems().get(getIndex());
                    deleteBorrowing(borrowing.getCod(), borrowing);
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

    public void loadBorrowings() {
        List<Borrowing> borrowings = borrowingService.findAll();
        borrowingTable.getItems().setAll(borrowings);
    }

    public void changeStatus(Borrowing borrowing) {

        currentBorrowing = borrowingService.findById(borrowing.getCod());

        if (currentBorrowing.isReturned()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("O empréstimo já foi devolvido.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("PegStock");
        alert.setHeaderText("Tem certeza que deseja marcar o empréstimo de " + borrowing.getBorrower() + " como devolvido?");
        alert.setContentText("Essa ação não poderá ser desfeita.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                borrowingService.devolution(borrowing.getCod());
                loadBorrowings();
            }
        });
    }

    public void deleteBorrowing(Long cod, Borrowing borrowing) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("PegStock");
        alert.setHeaderText("Tem certeza que deseja excluir o empréstimo de " + borrowing.getBorrower() + "?");
        alert.setContentText("Essa ação não poderá ser desfeita.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                borrowingService.delete(cod);
                loadBorrowings();
            }
        });

    }

    public void clearForm() {
        registerDateDevolution.setValue(null);
        registerQuantity.clear();
        registerBorrower.clear();
        registerResponsible.clear();
        registerMaterialId.clear();

        currentBorrowing = null;
    }

    @FXML
    void cancel(MouseEvent event) {
        registerBorrowingPageBackground.setVisible(false);
        registerBorrowingPage.setVisible(false);

        clearForm();
    }

    @FXML
    void registerBorrowing(MouseEvent event) {
        try{
            Method findById = MaterialService.class.getMethod("findById", Long.class);
            if (currentBorrowing == null){
                Borrowing borrowing = new Borrowing();
                borrowing.setExpirationDate(registerDateDevolution.getValue());
                borrowing.setQuantity(Integer.parseInt(registerQuantity.getText()));
                borrowing.setBorrower(registerBorrower.getText());
                borrowing.setResponsible(registerResponsible.getText());

                Material material = (Material) findById.invoke(materialService, Long.parseLong(registerMaterialId.getText()));
                borrowing.setMaterial(material);

                borrowingService.create(Long.parseLong(registerMaterialId.getText()), borrowing);
            } else {
                currentBorrowing.setExpirationDate(registerDateDevolution.getValue());
                currentBorrowing.setQuantity(Integer.parseInt(registerQuantity.getText()));
                currentBorrowing.setBorrower(registerBorrower.getText());
                currentBorrowing.setResponsible(registerResponsible.getText());

                currentMaterial = (Material) findById.invoke(materialService, Long.parseLong(registerMaterialId.getText()));
                currentBorrowing.setMaterial(currentMaterial);

                borrowingService.update(Long.parseLong(registerMaterialId.getText()), currentBorrowing);
            }

            loadBorrowings();
            registerBorrowingPageBackground.setVisible(false);
            registerBorrowingPage.setVisible(false);

            clearForm();

        }catch (Exception e){
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro ao salvar o empréstimo.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void showRegisterBorrowingPage(MouseEvent event) {
        registerBorrowingPageBackground.setVisible(true);
        registerBorrowingPage.setVisible(true);
    }

}
