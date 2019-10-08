/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tadeu
 */
public class Vendedor {
       private String nome;
   private int dependentes;
   private double salarioBase;
   private double vendas;
   
   public Vendedor(String nome, int dependentes){
        this.setNome(nome);
        this.setDependentes(dependentes);
        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    private void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dependentes
     */
    public int getDependentes() {
        return dependentes;
    }

    /**
     * @param dependentes the dependentes to set
     */
    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    /**
     * @return the salarioBase
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * @return the vendas
     */
    public double getVendas() {
        return vendas;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setVendas(double vendas) {
        this.vendas = vendas;
    }
}
