package com.GameStore.DAO;

import com.GameStore.DataBase.ConexaoDB;
import com.GameStore.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void salvar (User user) throws SQLException {
        if(user.getId() == 0) {
            inserir(user);
        } else {
            atualizar(user);
        }
    }

    private void inserir(User user) throws SQLException {
        String sql = "INSERT INTO user (name, email, password, phone, adress, cpf) VALUES (?, ?, ?, ?, ?, ?)";

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
}
