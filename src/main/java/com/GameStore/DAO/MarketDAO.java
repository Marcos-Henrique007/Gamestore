package com.GameStore.DAO;

import com.GameStore.Model.Market;
import com.GameStore.Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarketDAO {

    public void salvar(Market m) {

        String sql = "INSERT INTO market (user_id, game_id) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, m.getUserId());
            stmt.setInt(2, m.getGameId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Market> listar() {

        List<Market> lista = new ArrayList<>();

        String sql = "SELECT * FROM market";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Market market = new Market();

                market.setId(rs.getInt("id"));
                market.setUserId(rs.getInt("user_id"));
                market.setGameId(rs.getInt("game_id"));

                lista.add(market);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(Market market) {

        String sql = "UPDATE market SET user_id = ?, game_id = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, market.getUserId());
            stmt.setInt(2, market.getGameId());
            stmt.setInt(3, market.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {

        String sql = "DELETE FROM market WHERE id = ?";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}