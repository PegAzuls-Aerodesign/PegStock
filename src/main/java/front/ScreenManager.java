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
            // Remove leading slash if present to ensure consistent path handling
            String normalizedPath = fxmlFile.startsWith("/") ? fxmlFile.substring(1) : fxmlFile;
            
            URL fxmlLocation = getClass().getClassLoader().getResource(normalizedPath);
            if (fxmlLocation == null) {
                throw new IllegalArgumentException("FXML file not found: " + normalizedPath);
            }
    
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            loader.setControllerFactory(context::getBean);
    
            Parent root = loader.load();
    
            Scene scene = new Scene(root, 1024, 640);
            // Fix the stylesheet path similarly
            URL cssLocation = getClass().getClassLoader().getResource("front/styles/templateDesign.css");
            if (cssLocation != null) {
                scene.getStylesheets().add(cssLocation.toExternalForm());
            }
    
            stage.setTitle("PegStock");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load screen: " + fxmlFile, e);
        }
    }

}