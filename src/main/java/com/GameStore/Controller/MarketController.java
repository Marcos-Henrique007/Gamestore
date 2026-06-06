package com.GameStore.Controller;

import com.GameStore.DAO.MarketDAO;

public class MarketController {

    private final MarketDAO marketDAO = new MarketDAO();

    public void comprarJogo(int userId, int gameId) {
        try {
            marketDAO.inserir(userId, gameId);

            System.out.println("✓ Compra realizada com sucesso");

        } catch (Exception e) {
            System.err.println("Erro ao realizar compra:");
            e.printStackTrace();
        }
    }
}