package com.GameStore.DAO;

import com.GameStore.DataBase.ConexaoDB;
import com.GameStore.model.Market;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarketDAO {

    public void salvar(Market market) throws SQLException {
        if (market.getId() == 0) {
            inserir(market);
        } else {
            atualizar(market);
        }
    }

    private void inserir(Market market) throws SQLException {
        String sql = "INSERT INTO market (titulo, name_empresa, email, address, phone, cnpj) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, market.getTitulo());
            ps.setString(2, market.getNameEmpresa());
            ps.setString(3, market.getEmail());
            ps.setString(4, market.getAddress());
            ps.setString(5, market.getPhone());
            ps.setString(6, market.getCnpj());

            ps.executeUpdate();
        }
    }

    private void atualizar(Market market) throws SQLException {
        String sql = "UPDATE market SET titulo = ?, name_empresa = ?, email = ?, " +
                "address = ?, phone = ?, cnpj = ? WHERE id = ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, market.getTitulo());
            ps.setString(2, market.getNameEmpresa());
            ps.setString(3, market.getEmail());
            ps.setString(4, market.getAddress());
            ps.setString(5, market.getPhone());
            ps.setString(6, market.getCnpj());
            ps.setInt(7, market.getId());

            ps.executeUpdate();
        }
    }

    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM market WHERE id = ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Market> listar() throws SQLException {
        List<Market> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, name_empresa, email, address, phone, cnpj FROM market";

        try (Statement st = ConexaoDB.getInstance().getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Market market = new Market();
                market.setId(rs.getInt("id"));
                market.setTitulo(rs.getString("titulo"));
                market.setNameEmpresa(rs.getString("name_empresa"));
                market.setEmail(rs.getString("email"));
                market.setAddress(rs.getString("address"));
                market.setPhone(rs.getString("phone"));
                market.setCnpj(rs.getString("cnpj"));

                lista.add(market);
            }
        }
        return lista;
    }

    public List<Market> buscarPorNome(String nome) throws SQLException {
        List<Market> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, name_empresa, email, address, phone, cnpj " +
                "FROM market WHERE name_empresa LIKE ?";

        try (PreparedStatement ps = ConexaoDB.getInstance()
                .getConnection().prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Market market = new Market();
                    market.setId(rs.getInt("id"));
                    market.setTitulo(rs.getString("titulo"));
                    market.setNameEmpresa(rs.getString("name_empresa"));
                    market.setEmail(rs.getString("email"));
                    market.setAddress(rs.getString("address"));
                    market.setPhone(rs.getString("phone"));
                    market.setCnpj(rs.getString("cnpj"));

                    lista.add(market);
                }
            }
        }
        return lista;
    }
}
