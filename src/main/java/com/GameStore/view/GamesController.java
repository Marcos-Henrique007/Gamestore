package com.GameStore.view;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GamesController {

    @FXML private TextField txtNome;

    @FXML private TextField txtGenero;

    @FXML private TextField txtPreco;

    @FXML
    private void salvar() {
        System.out.println("Jogo salvo: " + txtNome.getText());
    }
}