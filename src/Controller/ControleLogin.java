/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.UsuariosDAO;
import Model.Carteira;
import Model.Extrato;
import Model.Investidor;
import Model.Moedas;
import View.Login;
import View.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        Investidor usuario = new Investidor(null, login.getTxtCpf().getText(), login.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuariosDAO dao = new UsuariosDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(login, "Login efetuado com sucesso!");
                String nome = res.getString("Nome");
                double real = res.getDouble("real");
                double bitcoin = res.getDouble("bitcoin");
                double ethereum = res.getDouble("ethereum");
                double ripple = res.getDouble("ripple");
                ArrayList<Moedas> moedas = new ArrayList<Moedas>();
                Carteira carteira = new Carteira(moedas);
                Extrato extrato = new Extrato();
                Investidor usuariodef = new Investidor(real, bitcoin, ethereum, ripple, nome, login.getTxtCpf().getText(), login.getTxtSenha().getText(), carteira, extrato);
                login.setVisible(false);
                Menu menu = new Menu(usuariodef);
                menu.setVisible(true);
            } else{
                JOptionPane.showMessageDialog(login, "Falha no Login! CPF ou senha inválido(s)!");
            }
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(login, "Erro ao se conectar!");
        }
        
}
}
