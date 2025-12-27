package com.GameStore.DataBase;

import java.sql.*;

public class ConexaoDB {
    private static ConexaoDB instancia;
    private Connection conexao;

    private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private ConexaoDB() { conectar(); }

    public static ConexaoDB getInstance() {
        if (instancia == null) instancia = new ConexaoDB();
        return instancia;
    }

    private void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✓ PostgreSQL conectado!");
        } catch (Exception e) {
            System.err.println("✗ Erro: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            if (conexao == null || conexao.isClosed()) conectar();
        } catch (SQLException e) {
            System.err.println("✗ Erro: " + e.getMessage());
        }
        return conexao;
    }

    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            System.err.println("✗ Erro: " + e.getMessage());
        }
    }
}
