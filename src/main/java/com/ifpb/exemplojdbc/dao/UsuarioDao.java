package com.ifpb.exemplojdbc.dao;

import com.ifpb.exemplojdbc.database.ConnectionFactory;
import com.ifpb.exemplojdbc.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Usuario buscarPorCpf(String cpf) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM usuario WHERE cpf = ?"
            );

            statement.setString(1, cpf);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                Usuario usuario = new Usuario();

                usuario.setCpf(resultSet.getString(1));
                usuario.setNome(resultSet.getString(2));
                usuario.setIdade(resultSet.getInt(3));

                return usuario;

            }else{
                return null;
            }

        }
    }

    public boolean deletarPorCpf(String cpf) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM usuario WHERE cpf=?"
            );

            statement.setString(1, cpf);

            return statement.executeUpdate()>0;
        }
    }

    public boolean atualizar(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE usuario SET nome=?, idade=? WHERE cpf=?"
            );

            statement.setString(1, usuario.getNome());
            statement.setInt(2, usuario.getIdade());
            statement.setString(3, usuario.getCpf());

            return statement.executeUpdate()>0;

        }
    }

}
