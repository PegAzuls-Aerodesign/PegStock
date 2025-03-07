package front.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;

public class StockController {

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

    @FXML
    void selectImage(MouseEvent event) {
        // Busca a imagem do botão clicado e exibe na tela
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
        // Exibe a página de registro
        buttonRegisterStock.setOnMouseClicked(event1 -> registerStockPageBackground.setVisible(true));
        buttonRegisterStock.addEventHandler(MouseEvent.MOUSE_CLICKED, event1 -> registerStockPage.setVisible(true));
    }
}
