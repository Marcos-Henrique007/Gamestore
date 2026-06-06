package com.GameStore.DAO;

import com.GameStore.DataBase.ConexaoDB;
import com.GameStore.Model.Games;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    public void inserir(Games game) {
        String sql = "INSERT INTO games (name, price) VALUES (?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (conn == null) {
                throw new RuntimeException("Conexão com banco falhou");
            }

            ps.setString(1, game.getName());
            ps.setDouble(2, game.getPrice());

            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Erro ao inserir jogo:");
            e.printStackTrace();
        }
    }

    public List<Games> listar() {
        List<Games> lista = new ArrayList<>();
        String sql = "SELECT id, name, price FROM games";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (conn == null) {
                throw new RuntimeException("Conexão com banco falhou");
            }

            while (rs.next()) {
                Games g = new Games();
                g.setId(rs.getInt("id"));
                g.setName(rs.getString("name"));
                g.setPrice(rs.getDouble("price"));
                lista.add(g);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar jogos:");
            e.printStackTrace();
        }

        return lista;
    }
}