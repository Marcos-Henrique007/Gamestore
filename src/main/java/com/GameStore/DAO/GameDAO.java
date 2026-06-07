package com.GameStore.DAO;

import com.GameStore.Util.ConnectionFactory;
import com.GameStore.Model.Games;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    public void salvar(Games game) {
        String sql = "INSERT INTO game (nome, preco) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, game.getName());
            stmt.setDouble(2, game.getPrice());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Games> listar() {
        List<Games> lista = new ArrayList<>();
        String sql = "SELECT * FROM game";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Games g = new Games();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("nome"));
                g.setPrice(rs.getDouble("preco"));
                lista.add(g);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(Games game) {
        String sql = "UPDATE game SET nome = ?, preco = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, game.getName());
            stmt.setDouble(2, game.getPrice());
            stmt.setInt(3, game.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM game WHERE id = ?";

        try (Connection conn = ConnectionFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}