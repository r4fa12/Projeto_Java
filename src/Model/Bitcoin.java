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
    public double getTaxaComprar(){
        return 0.02;
    }
    
    public double getTaxaVender(){
        return 0.03;
    }
    
}
