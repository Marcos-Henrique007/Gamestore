package com.GameStore.Controller;

import com.GameStore.DAO.UserDAO;
import com.GameStore.Model.User;
import com.GameStore.view.Navegador;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class UserController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TableView<User> tabela;

    @FXML
    private TableColumn<User, String> colNome;

    @FXML
    private TableColumn<User, String> colEmail;

    private UserDAO dao = new UserDAO();

    private User selecionado;

    @FXML
    public void initialize() {

        colNome.setCellValueFactory(
                data -> new SimpleStringProperty(data.getValue().getName())
        );

        colEmail.setCellValueFactory(
                data -> new SimpleStringProperty(data.getValue().getEmail())
        );

        carregarTabela();

        tabela.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {

                    if (newVal != null) {

                        selecionado = newVal;

                        txtNome.setText(newVal.getName());
                        txtEmail.setText(newVal.getEmail());
                    }
                }
        );
    }

    @FXML
    public void voltar() {
        Navegador.trocarTela("telainicial.fxml");
    }

    @FXML
    public void salvar() {

        User user = new User();

        user.setName(txtNome.getText());
        user.setEmail(txtEmail.getText());

        dao.salvar(user);

        carregarTabela();
        limpar();
    }

    @FXML
    public void atualizar() {

        if (selecionado != null) {

            selecionado.setName(txtNome.getText());
            selecionado.setEmail(txtEmail.getText());

            dao.atualizar(selecionado);

            carregarTabela();
            limpar();
        }
    }

    @FXML
    public void deletar() {

        if (selecionado != null) {

            dao.deletar(selecionado.getId());

            carregarTabela();
            limpar();
        }
    }

    private void carregarTabela() {
        tabela.getItems().setAll(dao.listar());
    }

    private void limpar() {
        txtNome.clear();
        txtEmail.clear();
        selecionado = null;
    }
}