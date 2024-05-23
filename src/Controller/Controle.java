/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.UsuariosDAO;
import Model.Bitcoin;
import Model.Ethereum;
import Model.Investidor;
import Model.Ripple;
import View.Cotacao;
import java.text.DecimalFormat;
import java.util.Random;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import Model.Tarifa;
import View.ConsultarExtrato;


/**
 *
 * @author uniframendes
 */
public class Controle {
    Investidor usuario;
    Tarifa tarifa;

    public Controle(Investidor usuario) {
        this.usuario = usuario;
        
    }
    
    
    public void Depositar(double valor){
        usuario.setSaldoreal(usuario.getSaldoreal() + valor);
        usuario.getExtrato().setNomemoeda("real");
        JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso!", "Deposito Concluído", JOptionPane.INFORMATION_MESSAGE);
        this.InserirExtrato1(usuario, valor, "real", usuario.getCarteira().getMoedas().get(0).getCotacao(), 1);
        this.SalvarInfo();
    }
        
    
    public void Sacar(double valor){
        if(valor <= usuario.getSaldoreal()){
            usuario.setSaldoreal(usuario.getSaldoreal() - valor);
            JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!", "Saque Concluído", JOptionPane.INFORMATION_MESSAGE);
            this.InserirExtrato2(usuario, valor, "real", usuario.getCarteira().getMoedas().get(0).getCotacao(), 1);
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para efetuar o saque!", "Erro", JOptionPane.INFORMATION_MESSAGE);

        }
        
        this.SalvarInfo();
    }
    
    
     public void ComprarCriptoMoedas(double valor){
         double carrinho = 0;
         if(usuario.getExtrato().getNomemoeda().equals("bitcoin")){
             Bitcoin bit = (Bitcoin) usuario.getCarteira().getMoedas().get(1);
             double comprar = valor * usuario.getCarteira().getMoedas().get(1).getCotacao();
             carrinho = comprar + comprar * bit.getTaxaComprar();
             if(carrinho <= usuario.getSaldoreal()){
                 usuario.setSaldobitcoin(usuario.getSaldobitcoin() + valor);
                 usuario.setSaldoreal(usuario.getSaldoreal() - carrinho);
                 JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!", "Compra Concluída", JOptionPane.INFORMATION_MESSAGE); 
                 this.InserirExtrato1(usuario, valor, "bitcoin", usuario.getCarteira().getMoedas().get(1).getCotacao(), tarifa.TaxaComprarBitcoin);

             }else{
                 JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Compra Cancelada!", JOptionPane.ERROR_MESSAGE);
             }
        }
         if(usuario.getExtrato().getNomemoeda().equals("ethereum")){
             Ethereum ethe = (Ethereum) usuario.getCarteira().getMoedas().get(2);
             double comprar = valor * usuario.getCarteira().getMoedas().get(2).getCotacao();
             carrinho = comprar + comprar * ethe.getTaxaComprar();
             if(carrinho <= usuario.getSaldoreal()){
                 usuario.setSaldoethereum(usuario.getSaldoethereum() + valor);
                 usuario.setSaldoreal(usuario.getSaldoreal() - carrinho);
                 JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!", "Compra Concluída", JOptionPane.INFORMATION_MESSAGE);  
                 this.InserirExtrato1(usuario, valor, "ethereum", usuario.getCarteira().getMoedas().get(2).getCotacao(), tarifa.TaxaComprarEthereum);

            }else{
                 JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Compra Cancelada!", JOptionPane.ERROR_MESSAGE);
             }
        }
         if(usuario.getExtrato().getNomemoeda().equals("ripple")){
             Ripple rip = (Ripple) usuario.getCarteira().getMoedas().get(3);
             double comprar = valor * usuario.getCarteira().getMoedas().get(3).getCotacao();
             carrinho = comprar + comprar * rip.getTaxaComprar();
             if(carrinho <= usuario.getSaldoreal()){
                 usuario.setSaldoripple(usuario.getSaldoripple() + valor);
                 usuario.setSaldoreal(usuario.getSaldoreal() - carrinho);
                 JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!", "Compra Concluída", JOptionPane.INFORMATION_MESSAGE);  
                 this.InserirExtrato1(usuario, valor, "ripple", usuario.getCarteira().getMoedas().get(3).getCotacao(), tarifa.TaxaComprarRipple);
            }else{
                 JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Compra Cancelada!", JOptionPane.ERROR_MESSAGE);
             }
             
        }
         this.SalvarInfo();
    }  
     
     public void VenderCriptoMoedas(double valor){
         double carrinho = 0;
         if(usuario.getExtrato().getNomemoeda().equals("bitcoin")){
             if(valor <= usuario.getSaldobitcoin()){
                 Bitcoin bit = (Bitcoin) usuario.getCarteira().getMoedas().get(1);
                 double venda = valor * usuario.getCarteira().getMoedas().get(1).getCotacao();
                 carrinho = venda - venda * bit.getTaxaVender();
                 usuario.setSaldobitcoin(usuario.getSaldobitcoin() - valor);
                 usuario.setSaldoreal(usuario.getSaldoreal() + carrinho);
                 JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!", "Venda Concluída", JOptionPane.INFORMATION_MESSAGE); 
                 this.InserirExtrato2(usuario, valor, "bitcoin", usuario.getCarteira().getMoedas().get(1).getCotacao(), tarifa.TaxaComprarBitcoin);
             }else{
                 JOptionPane.showMessageDialog(null, "Saldo de Bitcoin insuficiente!", "Venda Cancelada!", JOptionPane.ERROR_MESSAGE);
             }
             
            }if(usuario.getExtrato().getNomemoeda().equals("ethereum")){
                 if(valor <= usuario.getSaldoethereum()){
                    Ethereum ethe = (Ethereum) usuario.getCarteira().getMoedas().get(2);
                    double venda = valor * usuario.getCarteira().getMoedas().get(2).getCotacao();
                    carrinho = venda - venda * ethe.getTaxaVender();
                    usuario.setSaldoethereum(usuario.getSaldoethereum() - valor);
                    usuario.setSaldoreal(usuario.getSaldoreal() + carrinho);
                    JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!", "Venda Concluída", JOptionPane.INFORMATION_MESSAGE);
                    this.InserirExtrato2(usuario, valor, "ethereum", usuario.getCarteira().getMoedas().get(2).getCotacao(), tarifa.TaxaComprarEthereum);
                 }else{
                 JOptionPane.showMessageDialog(null, "Saldo de Ethereum insuficiente!", "Venda Cancelada!", JOptionPane.ERROR_MESSAGE);
                 }
                 
             }if(usuario.getExtrato().getNomemoeda().equals("ripple")){
                System.out.println(usuario.getExtrato().getNomemoeda());
                 if(valor <= usuario.getSaldoripple()){
                    Ripple rip = (Ripple) usuario.getCarteira().getMoedas().get(3);
                    double venda = valor * usuario.getCarteira().getMoedas().get(3).getCotacao();
                    carrinho = venda - venda * rip.getTaxaVender();
                    usuario.setSaldoripple(usuario.getSaldoripple() - valor);
                    usuario.setSaldoreal(usuario.getSaldoreal() + carrinho);
                    JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso!", "Venda Concluída", JOptionPane.INFORMATION_MESSAGE);
                    this.InserirExtrato2(usuario, valor, "ripple", usuario.getCarteira().getMoedas().get(3).getCotacao(), tarifa.TaxaComprarRipple);
                 }else{
                 JOptionPane.showMessageDialog(null, "Saldo de Ripple insuficiente!", "Venda Cancelada!", JOptionPane.ERROR_MESSAGE);
                 }
                 
             }
         
         this.SalvarInfo();
     }
             
    
    public void Cotacao() throws SQLException{
        DecimalFormat df = new DecimalFormat("#.##");
        
        double cotacaobitcoin = usuario.getCarteira().getMoedas().get(1).getCotacao();
        double cotacaoethereum = usuario.getCarteira().getMoedas().get(2).getCotacao();
        double cotacaoripple = usuario.getCarteira().getMoedas().get(3).getCotacao();
        
        
        Random aleatorio = new Random();
        
        int valorbitcoin = aleatorio.nextInt(2);
        int valorethereum = aleatorio.nextInt(2);
        int valoripple = aleatorio.nextInt(2);
        
        double variacao = 0.05;
        
        if(valorbitcoin == 1){
            cotacaobitcoin += cotacaobitcoin * variacao;
        }else{
            cotacaobitcoin -= cotacaobitcoin * variacao;
        }
        
        if(valorethereum == 1){
            cotacaoethereum += cotacaoethereum * variacao;
        }else{
            cotacaoethereum -= cotacaoethereum * variacao;
        }
        
        if(valoripple == 1){
            cotacaoripple += cotacaoripple * variacao;
        }else{
            cotacaoripple -= cotacaoripple * variacao;
        }
        
        usuario.getCarteira().getMoedas().get(1).setCotacao(cotacaobitcoin);
        usuario.getCarteira().getMoedas().get(2).setCotacao(cotacaoethereum);
        usuario.getCarteira().getMoedas().get(3).setCotacao(cotacaoripple);
        SalvarCotacao("bitcoin", cotacaobitcoin);
        SalvarCotacao("ethereum", cotacaoethereum);
        SalvarCotacao("ripple", cotacaoripple);
        
        Cotacao cotacao = new Cotacao(usuario);
        cotacao.setVisible(true);
        
        String cotacaobitcoinf = df.format(cotacaobitcoin).replace(',', '.');
        String cotacaoethereumf = df.format(cotacaoethereum).replace(',', '.');
        String cotacaoripplef = df.format(cotacaoripple).replace(',', '.');
        cotacao.TxtPaneCotacao.setText("Nova cotação bitcoin: " + cotacaobitcoinf + "\nNova cotação ethereum: " + cotacaoethereumf + "\nNova cotação ripple: " + cotacaoripplef);
        
        
    }
        
    public void SalvarCotacao(String nome, double cotacao) throws SQLException{
        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();
        UsuariosDAO dao = new UsuariosDAO(conn);
        dao.SalvarCotacao(nome, cotacao);
    }
    
    public void SalvarInfo(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            dao.SalvarInfo(usuario);
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao efetuar conexão!", "ERRO", ERROR_MESSAGE);
        }
        
    }
    
    public void InserirExtrato1(Investidor usuario, double quantidade, String moeda, double cotacao, double taxa){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            dao.InserirExtrato1(usuario, quantidade, moeda, cotacao, taxa);
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao efetuar conexão!", "ERRO", ERROR_MESSAGE);
        }
    }
        
    public void InserirExtrato2(Investidor usuario, double quantidade, String moeda, double cotacao, double taxa){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            dao.InserirExtrato2(usuario, quantidade, moeda, cotacao, taxa);
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao efetuar conexão!", "ERRO", ERROR_MESSAGE);
        }
    }
    
    public void LerExtrato(ConsultarExtrato Extrato){
        String extrato;
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            extrato = dao.LerExtrato(usuario);
            Extrato.TxtAreaExtrato.setText(extrato);
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao efetuar conexão!", "ERRO", ERROR_MESSAGE);
        }
        
        
    }

    
}
