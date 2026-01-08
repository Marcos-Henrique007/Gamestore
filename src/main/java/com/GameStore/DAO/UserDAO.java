package com.GameStore.DAO;

import com.GameStore.DataBase.ConexaoDB;
import com.GameStore.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void salvar(User user) throws SQLException {
        if (user.getId() == null || user.getId() == 0) {
            inserir(user);
        } else {
            atualizar(user);
        }
    }

    private void inserir(User user) throws SQLException {
        String sql = "INSERT INTO user (name, email, password, phone, address, cpf) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getCpf());

            ps.executeUpdate();
        }
    }

    private void atualizar(User user) throws SQLException {
        String sql = "UPDATE user SET name = ?, email = ?, password = ?, phone = ?, address = ?, cpf = ? WHERE id = ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getCpf());
            ps.setInt(7, user.getId());

            ps.executeUpdate();
        }
    }

    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<User> listar() throws SQLException {
        List<User> lista = new ArrayList<>();
        String sql = "SELECT id, name, email, password, phone, address, cpf FROM user";

        try (Statement st = ConexaoDB.getInstance().getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setCpf(rs.getString("cpf"));

                lista.add(user);
            }
        }
        return lista;
    }

    public List<User> buscarPorNome(String name) throws SQLException {
        List<User> lista = new ArrayList<>();
        String sql = "SELECT id, name, email, password, phone, address, cpf FROM user WHERE name LIKE ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setPhone(rs.getString("phone"));
                    user.setAddress(rs.getString("address"));
                    user.setCpf(rs.getString("cpf"));

                    lista.add(user);
                }
            }
        }
        return lista;
    }
}
