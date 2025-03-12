package front;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pegazuls.aerodesign.PegStock.PegStockApplication;

@Configuration
@ComponentScan(basePackages = {"front", "com.pegazuls.aerodesign.PegStock"})
public class PegStockFront extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        // Inicializa o contexto do Spring
        context = SpringApplication.run(PegStockApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Obtém o ScreenManager do contexto do Spring
        ScreenManager screenManager = context.getBean(ScreenManager.class);
        screenManager.setStage(stage);

        // Carrega a tela inicial
        screenManager.changeScreen("/front/fxml/PegStock.fxml");
    }

    @Override
    public void stop() throws Exception {
        // Fecha o contexto do Spring ao fechar a aplicação
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}