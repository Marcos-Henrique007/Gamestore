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

            Scene scene = new Scene(root, 900, 600);

            stage.setTitle("GameStore");
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}