package front;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class ScreenManager {

    @FXML
    private Pane contentPane;
    private Stage stage;

    @Autowired
    private ApplicationContext context;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void changeScreen(String fxmlFile) {
        try {
            URL fxmlLocation = getClass().getResource(fxmlFile);
            if (fxmlLocation == null) {
                throw new IllegalArgumentException("FXML file not found: " + fxmlFile);
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            loader.setControllerFactory(context::getBean);

            Parent root = loader.load();

            stage.setTitle("PegStock");
            stage.setScene(new Scene(root, 1024, 640));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
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

}