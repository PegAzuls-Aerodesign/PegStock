package front;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
    private Text nameOut;

    @FXML
    private AnchorPane stockPage;

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

}
