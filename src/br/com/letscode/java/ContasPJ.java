package br.com.letscode.java;

import java.math.BigDecimal;

public class ContasPJ extends Contas{

    public void transferir(int idEnviar, int idReceber, BigDecimal transferencia){
        BigDecimal valorTaxado = transferencia.multiply(new BigDecimal("1.005"));
        System.out.println("Sera cobrado uma taxa de 0.5% no valor da transferencia");
        int compare = this.clientes[idEnviar].getSaldoConta().compareTo(transferencia);
        if (compare >= 0) {
            this.clientes[idEnviar].subSaldoConta(valorTaxado);
            this.clientes[idReceber].addSaldoConta(transferencia);
            System.out.println("Foi transferido R$" + transferencia + " para a conta de "
                    + this.clientes[idReceber].getNome());
        } else {
            System.out.println("Seu saldo é insuficiente");
        }
    }

    public void saque(int id, BigDecimal valor){
        System.out.println("Foi sacado R$" + valor + " da sua conta, e foi cobrada uma taxa de 0,5%");
        valor = valor.multiply(new BigDecimal("1.005"));
        this.clientes[id].subSaldoConta(valor);
    }

    public void retornaSaldoInvestimento(int id){
        System.out.println("Saldo de R$" + this.clientes[id].getSaldoConta());
        BigDecimal rendimento = this.clientes[id].getSaldoConta().multiply(new BigDecimal("0.04"));
        this.clientes[id].addSaldoConta(rendimento);
        System.out.println("Mais rendimento de " + rendimento);
    }

}
