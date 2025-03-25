package com.pegazuls.aerodesign.PegStock.controllers;

import com.pegazuls.aerodesign.PegStock.commands.CommandInvoker;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import com.pegazuls.aerodesign.PegStock.service.ShoppingListService;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;

@Controller
public class DashboardController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private CommandInvoker commandInvoker;

    @FXML
    private Button buttonRelatorio;

    @FXML
    private BarChart<?, ?> consumeeadicao;

    @FXML
    private Text dateValid;

    @FXML
    private LineChart<?, ?> evolucaogastos;

    @FXML
    private Text nameCaro, nameConsumido, nameDisponivel, nameValidade, numberCaro, numberConsumido;

    @FXML
    private Text numberDisponivel;

    @FXML
    public void initialize() {
        getMostConsumedMaterial();
        getMostAvailableMaterial();
        getMostExpensiveMaterial();
        getExpirationDate();
    }

    @FXML
    public void openReport(MouseEvent event) {
        commandInvoker.generateReport();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("PegStock");
        alert.setHeaderText("Relatorio de ações gerado com sucesso");
        alert.setContentText("O relatorio foi gerado com sucesso e salvo em report.csv");
        alert.showAndWait();
    }

    private void getMostConsumedMaterial() {
        var mostConsumedMaterial = materialService.getMostConsumer();
        nameConsumido.setText(mostConsumedMaterial.name());
        numberConsumido.setText(String.valueOf(mostConsumedMaterial.quantity()));
    }

    private void getMostAvailableMaterial() {
        var mostAvailableMaterial = materialService.mostAvailable();
        nameDisponivel.setText(mostAvailableMaterial.name());
        numberDisponivel.setText(String.valueOf(mostAvailableMaterial.quantity()));
    }

    private void getMostExpensiveMaterial() {
        var mostExpensiveMaterial = shoppingListService.findMostExpensive();
        nameCaro.setText(mostExpensiveMaterial.name());
        numberCaro.setText(String.valueOf(mostExpensiveMaterial.price()));
    }

    private void getExpirationDate() {
        var expirationDate = materialService.nearestExpiration();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = expirationDate.expirationDate().format(formatter);

        nameValidade.setText(expirationDate.name());
        dateValid.setText(date);

    }

}
