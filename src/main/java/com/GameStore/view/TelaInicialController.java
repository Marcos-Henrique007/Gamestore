package com.GameStore.view;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class TelaInicialController {

    private Stage getStage() {
        return (Stage) javafx.stage.Window.getWindows().get(0);
    }
    @FXML
    private void abrirGames() {
        Navegador.trocarTela(getStage(), "game.fxml");
    }

    @FXML
    private void abrirUsers() {
        Navegador.trocarTela(getStage(), "user.fxml");
    }

    @FXML
    private void abrirMarket() {
        Navegador.trocarTela(getStage(), "market.fxml");
    }
}
