package com.GameStore.Controller;

import com.GameStore.DAO.GameDAO;
import com.GameStore.Model.Games;

import java.util.List;

public class GamesController {

    private final GameDAO gameDAO = new GameDAO();

    public void criarGame(String nome, double preco) {
        try {
            Games games = new Games();
            games.setName(nome);
            games.setPrice(preco);

            gameDAO.inserir(games);

            System.out.println("Jogo cadastrado com sucesso");

        } catch (Exception e) {
            System.err.println("Erro no controller ao criar jogo:");
            e.printStackTrace();
        }
    }

    public List<Games> listarGames() {
        try {
            return gameDAO.listar();
        } catch (Exception e) {
            System.err.println("Erro ao listar jogos:");
            e.printStackTrace();
            return null;
        }
    }
}