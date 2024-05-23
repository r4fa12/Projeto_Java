/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafael
 */
public interface Tarifa {
    
    double TaxaComprarBitcoin = 0.02;
    double TaxaVenderBitcoin = 0.03;
    
    double TaxaComprarEthereum = 0.01;
    double TaxaVenderEthereum = 0.02; 
    
    double TaxaComprarRipple = 0.01;
    double TaxaVenderRipple = 0.01;
    
    double getTaxaComprar();
    double getTaxaVender();
}
