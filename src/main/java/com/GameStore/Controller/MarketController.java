package com.GameStore.Controller;
import com.GameStore.DAO.MarketDAO;
import com.GameStore.model.Market;
import java.util.List;

public class MarketController {

    private MarketDAO dao = new MarketDAO();

    public void salvar(Market market) throws Exception {
        dao.salvar(market);
    }

    public void deletar(Integer id) throws Exception {
        dao.deletar(id);
    }

    public List<Market> listar() throws Exception {
        return dao.listar();
    }

    public List<Market> buscarPorNome(String nome) throws Exception {
        return dao.buscarPorNome(nome);
    }
}
