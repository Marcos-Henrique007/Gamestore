package com.GameStore;

import com.GameStore.view.TelaInicial;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.mostrarTela(primaryStage);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
