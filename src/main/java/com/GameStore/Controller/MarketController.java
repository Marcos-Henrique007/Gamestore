package com.GameStore.Controller;

import com.GameStore.DAO.MarketDAO;
import com.GameStore.Model.Market;
import com.GameStore.view.Navegador;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MarketController {

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtGameId;

    @FXML
    private TableView<Market> tabela;

    @FXML
    private TableColumn<Market, Integer> colUserId;

    @FXML
    private TableColumn<Market, Integer> colGameId;

    private MarketDAO dao = new MarketDAO();

    private Market selecionado;

    @FXML
    public void initialize() {

        colUserId.setCellValueFactory(
                data -> new SimpleObjectProperty<>(data.getValue().getUserId())
        );

        colGameId.setCellValueFactory(
                data -> new SimpleObjectProperty<>(data.getValue().getGameId())
        );

        carregarTabela();

        tabela.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) -> {

                    if (newVal != null) {

                        selecionado = newVal;

                        txtUserId.setText(
                                String.valueOf(newVal.getUserId())
                        );

                        txtGameId.setText(
                                String.valueOf(newVal.getGameId())
                        );
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

        Market m = new Market();

        m.setUserId(
                Integer.parseInt(txtUserId.getText())
        );

        m.setGameId(
                Integer.parseInt(txtGameId.getText())
        );

        dao.salvar(m);

        carregarTabela();
        limpar();
    }

    @FXML
    public void atualizar() {

        if (selecionado != null) {

            selecionado.setUserId(
                    Integer.parseInt(txtUserId.getText())
            );

            selecionado.setGameId(
                    Integer.parseInt(txtGameId.getText())
            );

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

        txtUserId.clear();
        txtGameId.clear();

        selecionado = null;
    }
}