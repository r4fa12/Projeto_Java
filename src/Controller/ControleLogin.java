/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.UsuariosDAO;
import Model.Bitcoin;
import Model.Carteira;
import Model.Ethereum;
import Model.Extrato;
import Model.Investidor;
import Model.Moedas;
import Model.Real;
import Model.Ripple;
import View.Login;
import View.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author rafae
 */
public class ControleLogin {
    private Login login;

    public ControleLogin(Login login) {
        this.login = login;
    }
    
    
    public void LoginUsuarios(){
        String cpf = login.getTxtCpf().getText();
        String senha = login.getTxtSenha().getText();
        cpf = cpf.replace(".", "").replace("-", "");
        boolean cpfValido = cpf.length() == 11;
        boolean senhaValida = senha.matches("\\d{6}");
        if (!cpfValido || !senhaValida) {
            JOptionPane.showMessageDialog(login, "CPF ou senha inválido(s)!", "Falha no Login!", ERROR_MESSAGE);
            return;
        }
        Investidor usuario = new Investidor(null, login.getTxtCpf().getText(), login.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            ResultSet res = dao.consultar(usuario);
            ResultSet res3 = dao.ConsultarCotacao("bitcoin");
            ResultSet res4 = dao.ConsultarCotacao("ethereum");
            ResultSet res5 = dao.ConsultarCotacao("ripple");
            if(res.next()){
                JOptionPane.showMessageDialog(login, "Login efetuado com sucesso!");
                String nome = res.getString("Nome");
                double real = res.getDouble("real");
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double ripple = res.getDouble("ripple");
                double bitcot = res3.getDouble("cotacao");
                double ethecot = res4.getDouble("cotacao");
                double ripcot = res5.getDouble("cotacao");
                ArrayList<Moedas> moedas = new ArrayList<Moedas>();
                moedas.add(new Real(1));
                moedas.add(new Bitcoin(bitcot));
                moedas.add(new Ethereum(ethecot));
                moedas.add(new Ripple(ripcot));
                Carteira carteira = new Carteira(moedas);
                Extrato extrato = new Extrato();
                Investidor usuariodef = new Investidor(real, bitcoin, ethereum, ripple, nome, login.getTxtCpf().getText(), login.getTxtSenha().getText(), carteira, extrato);
                login.setVisible(false);
                Menu menu = new Menu(usuariodef);
                menu.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(login, "CPF ou senha inválido(s)!", "Falha no Login!", ERROR_MESSAGE);
            }
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(login, "Erro ao se conectar!", "ERRO", ERROR_MESSAGE);
        }
        
}
}
