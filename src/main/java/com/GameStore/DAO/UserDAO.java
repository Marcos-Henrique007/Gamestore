package com.GameStore.DAO;

import com.GameStore.DataBase.ConexaoDB;
import com.GameStore.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void inserir(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (conn == null) {
                throw new RuntimeException("Conexão com banco falhou");
            }

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());

            ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Erro ao inserir usuário:");
            e.printStackTrace();
        }
    }

    public List<User> listar() {
        List<User> lista = new ArrayList<>();
        String sql = "SELECT id, name, email FROM users";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (conn == null) {
                throw new RuntimeException("Conexão com banco falhou");
            }

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                lista.add(u);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar usuários:");
            e.printStackTrace();
        }

        return lista;
    }
}