package com.GameStore.Controller;

import com.GameStore.view.Navegador;
import javafx.fxml.FXML;

public class TelaInicialController {

    @FXML
    public void abrirGames() {
        Navegador.trocarTela("game.fxml");
    }

    @FXML
    public void abrirMarket() {
        Navegador.trocarTela("market.fxml");
    }

    @FXML
    public void abrirUsuarios() {
        Navegador.trocarTela("user.fxml");
    }
}