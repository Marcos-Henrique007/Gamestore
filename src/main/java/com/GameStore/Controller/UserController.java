package com.GameStore.Controller;

import java.util.List;
import com.GameStore.model.User;
import com.GameStore.DAO.UserDAO;


public class UserController {
    private UserDAO dao = new UserDAO();

    public void salvar(User user) throws Exception {
        dao.salvar(user);
    }

    public void deletar(Integer id) throws Exception {
        dao.deletar(id);
    }

    public List<User> listar() throws Exception {
        return dao.listar();
    }

    public List<User> buscarPorNome(String name) throws Exception {
        return dao.buscarPorNome(name);
    }
}
