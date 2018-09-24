package com.ifpb.exemplojdbc.view;

import com.ifpb.exemplojdbc.dao.UsuarioDao;
import com.ifpb.exemplojdbc.database.ConnectionFactory;
import com.ifpb.exemplojdbc.model.Usuario;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        UsuarioDao dao = new UsuarioDao();

        try{

//            System.out.println(dao.salvar(new Usuario("222.222.222-02",
//                    "Maria", 19)));

//            System.out.println(dao.buscarPorCpf("111.111.111-01"));

//            System.out.println(dao.deletarPorCpf("111.111.111-01"));
//            System.out.println(dao.buscarPorCpf("111.111.111-01"));

            Usuario usuario = dao.buscarPorCpf("222.222.222-02");
            usuario.setNome("Maria da Silva");

            dao.atualizar(usuario);

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }

}
