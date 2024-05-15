/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author rafae
 */
public class Conexao {
    public Connection getConnection() throws SQLException{
        try{
            Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/Projeto", "postgres", "1208");
            System.out.println("Conexão sucedida!");
            return conexao;
                  
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
       
    }
}
