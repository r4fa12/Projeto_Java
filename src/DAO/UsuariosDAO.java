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
    
    public ResultSet consultar(Investidor usuario) throws SQLException{
        String sql = "select * from Usuarios.Pessoa where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet ConsultarCotacao(String nome) throws SQLException{
        String sql = "select cotacao from Usuarios.Moedas where nomemoeda = ?";
        PreparedStatement statement = null;
        ResultSet result = null;
        try{
            statement = conn.prepareStatement(sql);
            statement.setString(1, nome);
            statement.execute();
            result = statement.getResultSet();
            if (result.next()) {
            return result;
        } else {
            return null;
        }
        }catch(SQLException e){
            System.out.println(e);
        }
        return result;
        
        
    }
    
    public void SalvarCotacao(String nomemoeda, double cotacao) throws SQLException{
        String sql = "update Usuarios.Moedas set cotacao = ? where nomemoeda = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, cotacao);
        statement.setString(2, nomemoeda);
        statement.execute();
        
    }
    
    public void SalvarInfo(Investidor usuario) throws SQLException{
        String sql = "update Usuarios.Pessoa set real = ?, bitcoin = ?, ethereum = ?, ripple = ? where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, usuario.getSaldoreal());
        statement.setDouble(2, usuario.getSaldobitcoin());
        statement.setDouble(3, usuario.getSaldoethereum());
        statement.setDouble(4, usuario.getSaldoripple());
        statement.setString(5, usuario.getCpf());
        statement.setString(6, usuario.getSenha());
        statement.executeUpdate();
    }
    
    public void InserirExtrato1(Investidor usuario, double quantidade, String moeda, double cotacao, double taxa) throws SQLException{
        String sql = "insert into Usuarios.Extrato (cpf, data, mm, quantidade, moeda, cotacao, taxa, real, bitcoin, ethereum, ripple)"
                + "values ('"+ usuario.getCpf() +"', '"+ this.data() +"', '"+ "+" +"', '"+ quantidade +"', '"+ moeda +"', '"+ cotacao +"', '"+ taxa +"', "
                + "'"+ usuario.getSaldoreal() +"', '"+ usuario.getSaldobitcoin() +"', '"+ usuario.getSaldoethereum() +"', '"+ usuario.getSaldoripple() +"')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
    }
    
    public void InserirExtrato2(Investidor usuario, double quantidade, String moeda, double cotacao, double taxa) throws SQLException{
        String sql = "insert into Usuarios.Extrato (cpf, data, mm, quantidade, moeda, cotacao, taxa, real, bitcoin, ethereum, ripple)"
                + "values ('"+ usuario.getCpf() +"', '"+ this.data() +"', '"+ "-" +"', '"+ quantidade +"', '"+ moeda +"', '"+ cotacao +"', '"+ taxa +"', "
                + "'"+ usuario.getSaldoreal() +"', '"+ usuario.getSaldobitcoin() +"', '"+ usuario.getSaldoethereum() +"', '"+ usuario.getSaldoripple() +"')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
    }
    
    
    public String data(){
        Date data = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy HH:mm");
        return simple.format(data);
        
    }
    
    public String LerExtrato(Investidor usuario) throws SQLException{
        String extrato = "";
        String sql = "select data, mm, quantidade, moeda, cotacao, taxa, real, bitcoin, ethereum, ripple from Usuarios.Extrato where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, usuario.getCpf());
        ResultSet rs = statement.executeQuery();
        try(rs){
            while(rs.next()){
            String data = rs.getString("data");
            String mm = rs.getString("mm");
            double quantidade = rs.getDouble("quantidade");
            String moeda = rs.getString("moeda");
            double taxa = rs.getDouble("taxa");
            String real = rs.getString("real");
            String bitcoin = rs.getString("bitcoin");
            String ethereum = rs.getString("ethereum");
            String ripple = rs.getString("ripple");
            extrato += "" + data + "  " + mm + "  " + quantidade + "  " + moeda + "  " + taxa + "  " + "  real: " + real + "  bitcoin: " + bitcoin + "  ethereum: " + ethereum + "  ripple: " + ripple + "\n\n";
        }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return extrato;
    }
}
