package com.pegazuls.aerodesign.PegStock.controllers.javafx;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private MaterialService materialService;

    @FXML
    private Text numberBASTAO_COLA_QUENTE, numberCOLA, numberDESEMPENHO, numberELETRICA, numberEPI_TI, 
        numberESTANTE, numberFERRAMENTAS, numberFERRAMENTAS_CORTANTES, numberFERRAMENTAS_ELETRICAS, 
        numberFITAS, numberLIMPEZA, numberLIXAS, numberOUTROS, numberPALITOS, numberPARAFUSO_DERIVADOS;

    @FXML
    public void initialize() {
        Map<Text, Box> textBoxMap = new HashMap<>();
        textBoxMap.put(numberBASTAO_COLA_QUENTE, Box.BASTAO_COLA_QUENTE);
        textBoxMap.put(numberCOLA, Box.COLA);
        textBoxMap.put(numberDESEMPENHO, Box.DESEMPENHO);
        textBoxMap.put(numberELETRICA, Box.ELETRICA);
        textBoxMap.put(numberEPI_TI, Box.EPI_TI);
        textBoxMap.put(numberESTANTE, Box.ESTANTE);
        textBoxMap.put(numberFERRAMENTAS, Box.FERRAMENTAS);
        textBoxMap.put(numberFERRAMENTAS_CORTANTES, Box.FERRAMENTAS_CORTANTES);
        textBoxMap.put(numberFERRAMENTAS_ELETRICAS, Box.FERRAMENTAS_ELETRICAS);
        textBoxMap.put(numberFITAS, Box.FITAS);
        textBoxMap.put(numberLIMPEZA, Box.LIMPEZA);
        textBoxMap.put(numberLIXAS, Box.LIXAS);
        textBoxMap.put(numberOUTROS, Box.OUTROS);
        textBoxMap.put(numberPALITOS, Box.PALITOS);
        textBoxMap.put(numberPARAFUSO_DERIVADOS, Box.PARAFUSO_DERIVADOS);

        textBoxMap.forEach((text, box) -> 
            text.setText(String.valueOf(materialService.countByBox(box)))
        );
    }
}