package com.GameStore.DAO;

import com.GameStore.DataBase.ConexaoDB;

import java.sql.*;

public class MarketDAO {

    public void inserir(int userId, int gameId) {
        String sql = "INSERT INTO market (user_id, game_id) VALUES (?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (conn == null) {
                throw new RuntimeException("Conexão com banco falhou");
            }

            ps.setInt(1, userId);
            ps.setInt(2, gameId);

            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Erro ao registrar compra:");
            e.printStackTrace();
        }
    }
}