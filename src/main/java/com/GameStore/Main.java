package com.GameStore;

import com.GameStore.view.Navegador;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Navegador.setStage(stage);
        Navegador.trocarTela("telainicial.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}