package br.com.letscode.java;

import java.math.BigDecimal;

public class ContasPF extends Contas{
    public void retornaSaldoInvestimento(int id){
        System.out.println("Saldo de R$" + this.clientes[id].getSaldoConta());
        BigDecimal rendimento = this.clientes[id].getSaldoConta().multiply(new BigDecimal("0.02"));
        this.clientes[id].addSaldoConta(rendimento);
        System.out.println("Mais rendimento de " + rendimento);
    }

}
