/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tadeu
 */

import model.Vendedor;
import model.CalculoSalario;

public class Server {
    
    public static void main(String[] args) {
        //cria se o funcionario com nome e numero de dependentes
        Vendedor funcionario1 = new Vendedor("Tadeu", 2);
        //passa se o seu salario base
        funcionario1.setSalarioBase(1555.0);
        //passa se a quantidade que vendeu
        funcionario1.setVendas(140000.00);
        // cria se a folha de pagamento passando como parametro funcionario e a data
        CalculoSalario folha1 = new CalculoSalario(funcionario1);
        
       folha1.Imprimir();
        
        
    }
 

}
