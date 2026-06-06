package com.GameStore.Controller;

import com.GameStore.DAO.UserDAO;
import com.GameStore.Model.User;

import java.util.List;

public class UserController {

    private final UserDAO userDAO = new UserDAO();

    public void criarUsuario(String nome, String email) {
        try {
            User user = new User();
            user.setName(nome);
            user.setEmail(email);

            userDAO.inserir(user);

            System.out.println("Usuário criado com sucesso");

        } catch (Exception e) {
            System.err.println("Erro no controller ao criar usuário:");
            e.printStackTrace();
        }
    }

    public List<User> listarUsuarios() {
        try {
            return userDAO.listar();
        } catch (Exception e) {
            System.err.println("Erro no controller ao listar usuários:");
            e.printStackTrace();
            return null;
        }
    }
}