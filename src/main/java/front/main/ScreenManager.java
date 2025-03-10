package front.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

            stage.setTitle("PegStock");
            stage.setScene(new Scene(root, 1024, 640));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}