/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafae
 */
public class Ripple extends Moedas implements Tarifa{  
    
    public Ripple(double cotacao){
        super(cotacao);
    }

    public double getTaxaComprar() {
        return Tarifa.TaxaComprarRipple;
    }

    public double getTaxaVender() {
        return Tarifa.TaxaVenderRipple;
    }

   
    
   
    
}
