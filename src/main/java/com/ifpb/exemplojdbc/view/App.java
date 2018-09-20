package com.ifpb.exemplojdbc.view;

import com.ifpb.exemplojdbc.dao.UsuarioDao;
import com.ifpb.exemplojdbc.database.ConnectionFactory;
import com.ifpb.exemplojdbc.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        UsuarioDao dao = new UsuarioDao();

        try{

            System.out.println(dao.salvar(new Usuario("111.111.111-01",
                    "João", 20)));

        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

    }

}
