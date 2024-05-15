/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Investidor;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rafael
 */
public class UsuariosDAO {
    private Connection conn;
    
    public UsuariosDAO(Connection conn){
        this.conn = conn;
    }
    
    public String data(){
        Date data = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy HH:mm");
        return simple.format(data);
        
    }
    
    public ResultSet consultar(Investidor usuario) throws SQLException{
        String sql = "select * from Usuarios.Pessoa where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
}
