package com.GameStore.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navegador {

    public static void trocarTela(Stage stage, String fxml) {
        try {
            Parent root = FXMLLoader.load(
                    Navegador.class.getResource("/com/GameStore/view/" + fxml)
            );
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}