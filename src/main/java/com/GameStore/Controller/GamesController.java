package com.GameStore.Controller;
import com.GameStore.model.Games;
import com.GameStore.DAO.GameDAO;
import java.util.List;

public class GamesController {
    private GameDAO dao = new GameDAO();

    public void salvar(Games game) throws Exception {
        dao.salvar(game);
    }

    public void deletar(Integer id) throws Exception {
        dao.deletar(id);
    }

    public List<Games> listar() throws Exception {
        return dao.listar();
    }

    public List<Games> buscarPorNome(String titulo) throws Exception {
        return dao.buscarPorNome(titulo);
    }
}
