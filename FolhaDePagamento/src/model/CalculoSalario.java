/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;

/**
 *
 * @author tadeu
 */
public class CalculoSalario {
      private double salarioBruto;
  private double salarioLiquido;
  private double comissao;
  private double IRPF;
  private double bonus;
  private double INSS;
  private double salarioFamilia;
  private Calendar mesAno;
  private Vendedor vendedor;
  
    public CalculoSalario(Vendedor nome){
        this.setVendedor(vendedor);
        Calendar data = Calendar.getInstance();
        this.setMesAno(data);
        calcularSalario();
        
    }
    private void calcularSalario(){
        this.setComissao(this.calcularComissao(this.getVendedor().getVendas()));
        this.setSalarioBruto(this.calcularSalarioBruto(this.getVendedor().getSalarioBase(), this.getComissao()));
        this.setBonus(this.calcularBonus(this.getVendedor().getVendas()));
        this.setINSS(this.calcularINSS(this.getSalarioBruto()));
        this.setIRPF(this.calcularIRPF(this.getSalarioBruto()));
        this.setSalarioFamilia(this.calcularSalarioFamilia(this.getVendedor().getDependentes(), this.getSalarioBruto()));
        this.setSalarioLiquido(calcularSalarioLiquido(getSalarioBruto(), getIRPF(), getINSS(), getBonus(), getSalarioFamilia()));
        
    }
    private double calcularComissao(Double vendas){
        if(vendas >= 150000.00){
            return vendas*0.07;
        }else if (vendas >= 100000.00){
            return vendas*0.05;
        }else if ( vendas >= 50000.00){
            return vendas*0.02;
        }else{
            return 0;
        }
        //retorna comissão
    }
    /**
     * 
     * @param salariobase
     * @param comissao
     * @return salarioBruto 
     */
    private double calcularSalarioBruto(double salariobase, double comissao){
        return salariobase + comissao;
      
    }
    /**
     * 
     * @param vendas
     * @return bonus
     */
    private double calcularBonus(double vendas ){
        if(vendas <= 100000.00){
            return 1000.00;
        }else{
            return 0;
        }

    }
    /**
     * 
     * @param salarioBruto
     * @return inss 
     */
    private double calcularINSS(double salarioBruto/*recebe como parametro salario bruto*/){
        if(salarioBruto > 3218.90){
            return 3218.90*0.11;
        }else if(salarioBruto > 1609.45){
            return salarioBruto*0.11;
        }else if(salarioBruto > 965.67){
            return salarioBruto*0.09;
        }else{
            return salarioBruto*0.08;
        }
        
    }
    /**
     * 
     * @param salarioBruto
     * @return irpf
     */
    private double calcularIRPF (double salarioBruto){
        if(salarioBruto > 3582.00){
            return salarioBruto*0.275-662.94;
        }else if( salarioBruto > 2866.70){
            return salarioBruto*0.225-483.84;
        }else if( salarioBruto > 2150){
            return salarioBruto*0.15-268.84;
        }else if(salarioBruto > 1434.59){
            return salarioBruto*0.075-107.59;
        }else{
            return 0;
        }
       
    }
    
    /**
     * 
     * @param dependentes
     * @param salarioBruto
     * @return salarioFailia
     */
    private double calcularSalarioFamilia(int dependentes, double salarioBruto){
        if(salarioBruto > 20000.00){
            return 0;
        }else if(salarioBruto > 10000.00){
            return 210.00*dependentes;
        }else{
            return 405.00*dependentes;
        }
        //retorna salario familia
    }
    
    /**
     * 
     * @param salarioBruto
     * @param irpf
     * @param inss
     * @param bonus
     * @param salarioFamilia
     * @return salarioLiquido 
     */
    
    private double calcularSalarioLiquido(double salarioBruto, double irpf, double inss, double bonus, double salarioFamilia){
        return  salarioBruto + irpf + inss + bonus + salarioFamilia;
        //retorna salario liquido
    }
    
    public void Imprimir(){
        System.out.println("FOLHA DE PAGAMENTO \n " + getMesAno() +
                "\nNome: " + this.getVendedor().getNome() +
                "\nSalário base: R$ " + this.getVendedor().getSalarioBase() +
                "\nTotal de vendas: R$ " + this.getVendedor().getVendas() +
                "\n---------------------------------------"+
                "\nComissão: R$ " + this.getComissao() +
                "\nSalário bruto: R$: " + this.getSalarioBruto() +
                "\n---------------------------------------"+
                "Bônus: R$ " + this.getBonus() + 
                "\nSalário família: R$ " + this.getSalarioFamilia() +
                "\n---------------------------------------"+
                "\nIRPF: R$ " + this.getIRPF() +
                "\nINSS: R$ " + this.getINSS() +
                "\n---------------------------------------"+
                "\nSalário líquido: R$ " + this.getSalarioLiquido() +
                "\n---------------------------------------"+
                "\n---------------------------------------"+
                "\n Número de dependentes: " + this.getVendedor().getDependentes());
        
    }

    /**
     * @return the salarioBruto
     */
    public double getSalarioBruto() {
        return salarioBruto;
    }

    /**
     * @param salarioBruto the salarioBruto to set
     */
    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    /**
     * @return the salarioLiquido
     */
    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    /**
     * @param salarioLiquido the salarioLiquido to set
     */
    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    /**
     * @return the comissao
     */
    public double getComissao() {
        return comissao;
    }

    /**
     * @param comissao the comissao to set
     */
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    /**
     * @return the IRPF
     */
    public double getIRPF() {
        return IRPF;
    }

    /**
     * @param IRPF the IRPF to set
     */
    public void setIRPF(double IRPF) {
        this.IRPF = IRPF;
    }

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the INSS
     */
    public double getINSS() {
        return INSS;
    }

    /**
     * @param INSS the INSS to set
     */
    public void setINSS(double INSS) {
        this.INSS = INSS;
    }

    /**
     * @return the salarioFamilia
     */
    public double getSalarioFamilia() {
        return salarioFamilia;
    }

    /**
     * @param salarioFamilia the salarioFamilia to set
     */
    public void setSalarioFamilia(double salarioFamilia) {
        this.salarioFamilia = salarioFamilia;
    }

    /**
     * @return the mesAno
     */
    public String getMesAno() {
        String str = this.mesAno.get(Calendar.MONTH) +"/"+ this.mesAno.get(Calendar.YEAR);
        return str;
    }

    /**
     * @param mesAno the mesAno to set
     */
    public void setMesAno(Calendar mesAno) {
        this.mesAno = mesAno;
    }

    /**
     * @return the nome
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     * @param nome the nome to set
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
