package com.GameStore.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navegador {

    private static Stage stage;

    public static void setStage(Stage s) {
        stage = s;
    }

    public static void trocarTela(String fxml) {

        try {
            Parent root = FXMLLoader.load(
                    Navegador.class.getResource("/com/GameStore/view/" + fxml)
            );

            stage.setScene(new Scene(root, 900, 600)); // tamanho fixo melhor
            stage.show();

        } catch (Exception e) {
            System.out.println("Erro ao carregar: " + fxml);
            e.printStackTrace();
        }
    }
}