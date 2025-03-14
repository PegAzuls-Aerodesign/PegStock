package com.pegazuls.aerodesign.PegStock.controllers;

import com.pegazuls.aerodesign.PegStock.commands.AddCommand;
import com.pegazuls.aerodesign.PegStock.commands.BorrowCommand;
import com.pegazuls.aerodesign.PegStock.commands.CommandInvoker;
import com.pegazuls.aerodesign.PegStock.commands.ConsumeCommand;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.BorrowingService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class DetailsController implements Initializable {

    private Material material;

    @Autowired
    private PegStockController screenManager;

    @Autowired
    private CommandInvoker invoker;

    @Autowired
    private AddCommand addCommand;

    @Autowired
    private ConsumeCommand consumeCommand;

    @Autowired
    private BorrowCommand borrowCommand;

    @Autowired
    private BorrowingService borrowingService;


    @FXML
    private Button buttonAdd, buttonBorrowing, buttonCancel, buttonConsumption, buttonCancelAdd;
  
    @FXML
    private Button buttonCancelConsume, buttonConfirmAdd, buttonConfirmConsume, buttonCancelBorrowing, buttonConfirmBorrowing;
  

    @FXML
    private Text code, dateAdd, dateConsumption, dateCriation, description,
            nameBox, nameCategory, nameTitle, nameValid, quantity,
            totalConsumption;

    @FXML
    private TextField consumerQuant, addQuantity;

    @FXML
    private TextField borrower, responsible, borrowQuantity;

    @FXML
    private DatePicker expirationDate;
  
    @FXML
    private AnchorPane registerBackgroundPage, registerConsumePage, registerAddPage, registerBorrowingPage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (material != null) {
            updateUi();
        }
    }

    @FXML
    void showRegisterConsumePage(MouseEvent event) {
        registerBackgroundPage.setVisible(true);
        registerConsumePage.setVisible(true);
    }

    @FXML
        void showRegisterAddPage(MouseEvent event) {
        registerBackgroundPage.setVisible(true);
        registerAddPage.setVisible(true);
    }

    @FXML
    void showRegisterBorrowingPage(MouseEvent event) {
        registerBackgroundPage.setVisible(true);
        registerBorrowingPage.setVisible(true);
    }
  
    public void showDetails(Material material) {
        this.material = material;
        System.out.println(material);
        screenManager.loadScreen("/front/fxml/DetailsPage.fxml");
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
            dateAdd.setText(material.getLastAddDate() == null ? "N/A" : material.getLastAddDate().toString());
            dateConsumption.setText(material.getLastConsumptionDate() == null ? "N/A" : material.getLastConsumptionDate().toString());
        }
    }

    @FXML
    void cancel(MouseEvent event) {
        if(event.getSource() == buttonCancelAdd) {
            registerBackgroundPage.setVisible(false);
            registerAddPage.setVisible(false);
            clearForm();
        } else if(event.getSource() == buttonCancelConsume) {
            registerBackgroundPage.setVisible(false);
            registerConsumePage.setVisible(false);
            clearForm();
        } else if(event.getSource() == buttonCancelBorrowing) {
            registerBackgroundPage.setVisible(false);
            registerBorrowingPage.setVisible(false);
            clearForm();
        } else if (event.getSource() == buttonCancel) {
            screenManager.loadScreen("/front/fxml/StockPage.fxml");
        }
    }
  
    @FXML
    void confirm(MouseEvent event) {
        if(event.getSource() == buttonConfirmAdd) {
            int quantity = Integer.parseInt(addQuantity.getText());
            add(quantity);
            registerBackgroundPage.setVisible(false);
            registerAddPage.setVisible(false);

            clearForm();
        } else if(event.getSource() == buttonConfirmConsume) {
            int quantity = Integer.parseInt(consumerQuant.getText());
            consumer(quantity);
            registerBackgroundPage.setVisible(false);
            registerConsumePage.setVisible(false);

            clearForm();
        } else if(event.getSource() == buttonConfirmBorrowing) {
            addBorrowing();
            registerBackgroundPage.setVisible(false);
            registerBorrowingPage.setVisible(false);

            clearForm();
        }
    }

    public void consumer(int quantity) {
        try {
            consumeCommand.setParameters(material, quantity);
            invoker.execute(consumeCommand);
            updateUi();
        } catch (Exception e) {
            // Log the exception and handle it appropriately
            System.err.println("Error in consumer method:");
            e.printStackTrace();
        }
    }

    public void add(int quantity) {
        try {
            addCommand.setParameters(material, quantity);
            invoker.execute(addCommand);
            updateUi();
        } catch (Exception e) {
            // Log the exception and handle it appropriately
            System.err.println("Error in add method:");
            e.printStackTrace();

        }
    }

    public void addBorrowing() {
        try {
            Borrowing borrowing = new Borrowing();
            borrowing.setQuantity(Integer.parseInt(borrowQuantity.getText()));
            borrowing.setBorrower(borrower.getText());
            borrowing.setExpirationDate(expirationDate.getValue());
            borrowing.setResponsible(responsible.getText());
            borrowing.setMaterial(material);
            material.setQuantity(material.getQuantity() - borrowing.getQuantity()); // Gambiarra
            borrowCommand.setParameters(material, borrowing);
            invoker.execute(borrowCommand);
            updateUi();
        } catch (Exception e) {
            // Log the exception and handle it appropriately
            System.err.println("Error in addBorrowing method:");
            e.printStackTrace();
        }
    }

    public void clearForm() {
        addQuantity.clear();
        consumerQuant.clear();
        borrower.clear();
        responsible.clear();
        borrowQuantity.clear();
        expirationDate.getEditor().clear();
    }
}
