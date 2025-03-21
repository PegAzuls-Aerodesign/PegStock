package com.pegazuls.aerodesign.PegStock.controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardController {

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

}
