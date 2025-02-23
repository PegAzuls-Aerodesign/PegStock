package front;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class PegStockFront extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/front/fxml/PegStock.fxml")));
        primaryStage.setTitle("PegStock");

        // Defina o tamanho da tela aqui
        Scene scene = new Scene(root, 1024, 640);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}