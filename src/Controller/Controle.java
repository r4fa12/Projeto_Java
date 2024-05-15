/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Investidor;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author rafael
 */
public class Controle {
    Investidor usuario;

    public Controle(Investidor usuario) {
        this.usuario = usuario;
        
    }
    
    public void Depositar(double valor){
        usuario.setSaldoreal(usuario.getSaldoreal() + valor);
        JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso!", "Deposito Concluído", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void Sacar(double valor){
        if(valor <= usuario.getSaldoreal()){
            usuario.setSaldoreal(usuario.getSaldoreal() - valor);
            JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!", "Saque Concluído", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para efetuar o saque!", "Erro", JOptionPane.INFORMATION_MESSAGE);

        }
    }
    
    public String data(){
        Date data = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd/mm/yyyy HH:mm");
        return simple.format(data);
        
    }
    
}
