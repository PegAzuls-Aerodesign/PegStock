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

            Scene scene = new Scene(root, 1024, 640);
            scene.getStylesheets().add(getClass().getResource("/front/styles/templateDesign.css ").toExternalForm());

            stage.setTitle("PegStock");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}