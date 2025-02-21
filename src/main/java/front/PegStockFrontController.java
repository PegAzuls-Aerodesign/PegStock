package front;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class PegStockFrontController {

    @FXML
    private Button buttonBuy;

    @FXML
    private Button buttonDashboard;

    @FXML
    private Button buttonEstoque;

    @FXML
    private Button buttonHome;

    @FXML
    private Text nameOut;

    @FXML
    void nameChange(MouseEvent event) {
        // Dependendo do botão clicado, o nome do botão será exibido
        if (event.getSource() == buttonHome) {
            nameOut.setText(buttonHome.getText());
        } else if (event.getSource() == buttonDashboard) {
            nameOut.setText(buttonDashboard.getText());
        } else if (event.getSource() == buttonEstoque) {
            nameOut.setText(buttonEstoque.getText());
        } else if (event.getSource() == buttonBuy) {
            nameOut.setText(buttonBuy.getText());
        }
    }

}
