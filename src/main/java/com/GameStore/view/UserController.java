package com.GameStore.view;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UserController {

    @FXML private TextField txtNome;

    @FXML private TextField txtEmail;

    @FXML
    private void cadastrar() {
        System.out.println("Usuário cadastrado: " + txtNome.getText());
    }
}