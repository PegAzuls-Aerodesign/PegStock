package front.main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ScreenManager {
    @Setter
    private static Stage stage;

    public static void changeScreen(String fxmlFile){
        try {
            URL fxmlLocation = ScreenManager.class.getResource(fxmlFile);
            if (fxmlLocation == null) {
                throw new IllegalArgumentException("FXML file not found: " + fxmlFile);
            }
            Parent root = FXMLLoader.load(fxmlLocation);

            // Exemplo de como pegar um bean do contexto
            //String title = context.getBean("title", String.class);
            stage.setTitle("PegStock");

            // Defina o tamanho da tela aqui
            stage.setScene(new Scene(root, 1024, 640));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
