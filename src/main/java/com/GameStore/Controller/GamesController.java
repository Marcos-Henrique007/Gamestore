package com.GameStore.Controller;

import com.GameStore.DAO.GameDAO;
import com.GameStore.Model.Games;
import com.GameStore.view.Navegador;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GamesController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPreco;

    @FXML
    private TableView<Games> tabela;

    @FXML
    private TableColumn<Games, String> colNome;

    @FXML
    private TableColumn<Games, Double> colPreco;

    private GameDAO dao = new GameDAO();

    private Games selecionado;

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        colPreco.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPrice()));

        carregarTabela();

        tabela.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {
                    if (newVal != null) {
                        selecionado = newVal;
                        txtNome.setText(newVal.getName());
                        txtPreco.setText(String.valueOf(newVal.getPrice()));
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
        Games g = new Games();
        g.setName(txtNome.getText());
        g.setPrice(Double.parseDouble(txtPreco.getText()));

        dao.salvar(g);
        carregarTabela();
        limpar();
    }

    @FXML
    public void atualizar() {
        if (selecionado != null) {
            selecionado.setName(txtNome.getText());
            selecionado.setPrice(Double.parseDouble(txtPreco.getText()));

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
        txtPreco.clear();
        selecionado = null;
    }
}