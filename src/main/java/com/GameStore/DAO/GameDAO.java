package com.GameStore.DAO;

import com.GameStore.DataBase.ConexaoDB;
import com.GameStore.model.Games;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {

    public void salvar(Games game) throws SQLException {
        if (game.getId() == 0) {
            inserir(game);
        } else {
            atualizar(game);
        }
    }

    private void inserir(Games game) throws SQLException {
        String sql = "INSERT INTO games (name, price, barcode) VALUES (?, ?, ?)";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, game.getName());
            ps.setDouble(2, game.getPrice());
            ps.setString(3, game.getBarcode());

            ps.executeUpdate();
        }
    }

    private void atualizar(Games game) throws SQLException {
        String sql = "UPDATE games SET name = ?, price = ?, barcode = ? WHERE id = ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, game.getName());
            ps.setDouble(2, game.getPrice());
            ps.setString(3, game.getBarcode());
            ps.setInt(4, game.getId());

            ps.executeUpdate();
        }
    }

    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM games WHERE id = ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Games> listar() throws SQLException {
        List<Games> lista = new ArrayList<>();
        String sql = "SELECT id, name, price, barcode FROM games";

        try (Statement st = ConexaoDB.getInstance().getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Games game = new Games();
                game.setId(rs.getInt("id"));
                game.setName(rs.getString("name"));
                game.setPrice(rs.getDouble("price"));
                game.setBarcode(rs.getString("barcode"));

                lista.add(game);
            }
        }
        return lista;
    }

    public List<Games> buscarPorNome(String nome) throws SQLException {
        List<Games> lista = new ArrayList<>();
        String sql = "SELECT id, name, price, barcode FROM games WHERE name LIKE ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Games game = new Games();
                    game.setId(rs.getInt("id"));
                    game.setName(rs.getString("name"));
                    game.setPrice(rs.getDouble("price"));
                    game.setBarcode(rs.getString("barcode"));

                    lista.add(game);
                }
            }
        }
        return lista;
    }
}
