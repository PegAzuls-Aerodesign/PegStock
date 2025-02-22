package front;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;

public class PegStockFrontController {

    @FXML
    private Button buttonBuyList;

    @FXML
    private Button buttonDashboard;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonLoan;

    @FXML
    private Button buttonStock;

    @FXML
    private Button buttonNavigate;

    @FXML
    private Button buttonRegister;

    @FXML
    private ImageView imageView;

    @FXML
    private Text nameOut;

    @FXML
    private AnchorPane stockPage;

    @FXML
    private AnchorPane registerPage;

    @FXML
    private AnchorPane registerPageBackground;

    @FXML
    void pages(MouseEvent event) {
        // Dependendo do botão clicado, o nome do botão será exibido no Text e a Page muda
        if (event.getSource() == buttonHome) {
            buttonHome.setOnMouseClicked(event1 -> nameOut.setText(buttonHome.getText()));
        } else if (event.getSource() == buttonDashboard) {
            buttonDashboard.setOnMouseClicked(event1 -> nameOut.setText(buttonDashboard.getText()));
        } else if (event.getSource() == buttonStock) {
            buttonStock.setOnMouseClicked(event1 -> nameOut.setText(buttonStock.getText()));
            buttonStock.addEventHandler(MouseEvent.MOUSE_CLICKED, event1 -> stockPage.setVisible(true));
        } else if (event.getSource() == buttonBuyList) {
            buttonBuyList.setOnMouseClicked(event1 -> nameOut.setText(buttonBuyList.getText()));
        } else if (event.getSource() == buttonLoan) {
            buttonLoan.setOnMouseClicked(event1 -> nameOut.setText(buttonLoan.getText()));
        }
    }

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
    void showRegisterPage(MouseEvent event) {
        // Exibe a página de registro
        buttonRegister.setOnMouseClicked(event1 -> registerPageBackground.setVisible(true));
        buttonRegister.addEventHandler(MouseEvent.MOUSE_CLICKED, event1 -> registerPage.setVisible(true));
    }

}
