/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafae
 */
public class Ethereum extends Moedas implements Tarifa{
    
    public Ethereum(double cotacao){
        super(cotacao);
    }

    public double getTaxaComprar() {
        return Tarifa.TaxaComprarEthereum;
    }

    public double getTaxaVender() {
        return Tarifa.TaxaVenderEthereum;
    }
}
