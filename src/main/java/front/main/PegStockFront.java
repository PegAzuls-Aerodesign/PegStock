package front.main;

import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javafx.application.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "front")
public class PegStockFront extends Application {
   private static ApplicationContext context;

   public static void main(String[] args) {
      launch();
   }

   public static ApplicationContext getContext() {
      return context;
   }

   @Override
   public void start(Stage stage) throws Exception {
      var context = SpringApplication.run(PegStockFront.class);
      ScreenManager.setStage(stage);
      ScreenManager.changeScreen("/front/fxml/PegStock.fxml");



   }
}