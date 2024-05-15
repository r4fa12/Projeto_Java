/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author rafae
 */
public class Carteira{
    private ArrayList<Moedas> moedas;

    public ArrayList<Moedas> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<Moedas> moedas) {
        this.moedas = moedas;
    }
    
    public Carteira(ArrayList<Moedas> moedas){
        this.moedas = moedas;
    }
}
