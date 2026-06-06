package com.GameStore.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection conexao;

    public static Connection getConnection() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conectado ao banco");
            }
        } catch (SQLException e) {
            System.err.println("ERRO AO CONECTAR:");
            e.printStackTrace();
        }
        return conexao;
    }
}