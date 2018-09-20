package com.ifpb.exemplojdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/POO";
        String usuario = "postgres";
        String senha = "postgres";

        return DriverManager.getConnection(url, usuario, senha);

    }

}
