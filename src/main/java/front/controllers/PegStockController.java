package front.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@Component
@Configuration
public class PegStockController {

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
    private Button buttonStock;

    @FXML
    private Text nameOut;

    @FXML
    private Pane contentPane;

    @FXML
    void pages(MouseEvent event) {
        // Dependendo do botão clicado, o nome do botão será exibido no Text e a Page muda
        if (event.getSource() == buttonHome) {
            buttonHome.setOnMouseClicked(event1 -> nameOut.setText(buttonHome.getText()));
        } else if (event.getSource() == buttonDashboard) {
            buttonDashboard.setOnMouseClicked(event1 -> nameOut.setText(buttonDashboard.getText()));
        } else if (event.getSource() == buttonStock) {
            buttonStock.setOnMouseClicked(event1 -> nameOut.setText(buttonStock.getText()));
            buttonStock.addEventHandler(MouseEvent.MOUSE_CLICKED, event1 -> showStock());
        } else if (event.getSource() == buttonBuyList) {
            buttonBuyList.setOnMouseClicked(event1 -> nameOut.setText(buttonBuyList.getText()));
            buttonBuyList.addEventHandler(MouseEvent.MOUSE_CLICKED, event1 -> showShoppingList());
        } else if (event.getSource() == buttonLoan) {
            buttonLoan.setOnMouseClicked(event1 -> nameOut.setText(buttonLoan.getText()));
        }
    }

    public void loadScreen(String fxmlFile) {
        // Carrega a tela de acordo com o botão clicado
        try {
            URL fxmlLocation = getClass().getResource(fxmlFile);
            if (fxmlLocation == null) {
                throw new IllegalArgumentException("FXML file not found" + fxmlFile);
            }
            Parent screen = FXMLLoader.load(fxmlLocation);

            // Garante que a tela carregada preencha o contentPane
            AnchorPane.setTopAnchor(screen, 0.0);
            AnchorPane.setBottomAnchor(screen, 0.0);
            AnchorPane.setLeftAnchor(screen, 0.0);
            AnchorPane.setRightAnchor(screen, 0.0);

            contentPane.getChildren().setAll(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStock(){
        loadScreen("/front/fxml/StockPage.fxml");
    }

    public void showShoppingList(){
        loadScreen("/front/fxml/ShoppingListPage.fxml");
    }

}
