/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafae
 */
public class Bitcoin extends Moedas implements Tarifa{
    
    public Bitcoin(double cotacao){
        super (cotacao);
    }
    
    public double getTaxaComprar(){
        return Tarifa.TaxaComprarBitcoin;
    }
    
    public double getTaxaVender(){
        return Tarifa.TaxaVenderBitcoin;
    }
}
