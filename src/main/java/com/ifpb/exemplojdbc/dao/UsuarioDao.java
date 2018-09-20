package com.ifpb.exemplojdbc.dao;

import com.ifpb.exemplojdbc.database.ConnectionFactory;
import com.ifpb.exemplojdbc.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {

    private ConnectionFactory factory;

    public UsuarioDao(){
        factory = new ConnectionFactory();
    }

    public boolean salvar(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO usuario (cpf, nome, idade)" +
                            " VALUES (?,?,?)");

            statement.setString(1,usuario.getCpf());
            statement.setString(2, usuario.getNome());
            statement.setInt(3, usuario.getIdade());

            return statement.executeUpdate()>0;

        }
    }

}
