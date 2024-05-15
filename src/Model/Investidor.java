/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rafae
 */
public class Investidor extends Pessoa{
    private double saldoreal, saldobitcoin, saldoethereum, saldoripple;
    private Carteira carteira;
    private Extrato extrato;

    public double getSaldoreal() {
        return saldoreal;
    }

    public void setSaldoreal(double saldoreal) {
        this.saldoreal = saldoreal;
    }

    public double getSaldobitcoin() {
        return saldobitcoin;
    }

    public void setSaldobitcoin(double saldobitcoin) {
        this.saldobitcoin = saldobitcoin;
    }

    public double getSaldoethereum() {
        return saldoethereum;
    }

    public void setSaldoethereum(double saldoethereum) {
        this.saldoethereum = saldoethereum;
    }

    public double getSaldoripple() {
        return saldoripple;
    }

    public void setSaldoripple(double saldoripple) {
        this.saldoripple = saldoripple;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public Extrato getExtrato() {
        return extrato;
    }

    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
    }
    
    

    public Investidor(double saldoreal, double saldobitcoin, double saldoethereum, double saldoripple, String nome, String cpf, String senha, Carteira carteira, Extrato extrato) {
        super(nome, cpf, senha);
        this.saldoreal = saldoreal;
        this.saldobitcoin = saldobitcoin;
        this.saldoethereum = saldoethereum;
        this.saldoripple = saldoripple;
        this.carteira = carteira;
        this.extrato = extrato;
    }
    
    public Investidor(String nome, String cpf, String senha){
        super(nome, cpf, senha);
    }
    
}
