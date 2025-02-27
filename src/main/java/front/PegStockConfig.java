package front;

import java.util.concurrent.CompletableFuture;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Application;

public class PegStockConfig {
   private static ApplicationContext context;

   public static void main(String[] args) {
      CompletableFuture.runAsync(() -> {
         context = new AnnotationConfigApplicationContext(PegStockConfig.class);
         Application.launch(PegStockFront.class, args);
      });
   }

   public static ApplicationContext getContext() {
      return context;
   }
}