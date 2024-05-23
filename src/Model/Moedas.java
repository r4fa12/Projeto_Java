/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafae
 */
public class Moedas{
    private double taxavender, taxacomprar, cotacao;

    public Moedas(double taxavender, double taxacomprar, double cotacao) {
        this.taxavender = taxavender;
        this.taxacomprar = taxacomprar;
        this.cotacao = cotacao;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
    
    public Moedas(double cotacao){
        this.cotacao = cotacao;
    }
    
    public Moedas(){
        
    }
    
    
}
