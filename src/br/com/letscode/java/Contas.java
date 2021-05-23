package br.com.letscode.java;

import java.math.BigDecimal;

public class Contas implements Operacoes{
    int qtdClientes = 0;
    Cliente[] clientes;

    public Contas() {
        this.clientes = new Cliente[10];
    }

    public Boolean adicionarConta(Cliente novoCliente){
        if (this.qtdClientes < clientes.length){
            this.clientes[qtdClientes] = novoCliente;
            qtdClientes++;
            return true;
        }
        else {
            System.out.println("Para manter um bom atendimento aos seus clientes" +
                    "o BANCO MEYUHAD tem um limite estrito de contas, devido a isso nao poderemos" +
                    "aceitar o seu cadastro.");
            return false;
        }
    }

    public int indiceConta() {
        return qtdClientes;
    }

    public void retornaSaldo(int id){
        System.out.println("Saldo de R$" + this.clientes[id].getSaldoConta());
    }

    public void depositar(int id, BigDecimal deposito){
        this.clientes[id].addSaldoConta(deposito);
        System.out.println("Foi depositado R$" + deposito + " em sua conta");
    }


    public void transferir(int idEnviar, int idReceber, BigDecimal transferencia){
        int compare = this.clientes[idEnviar].getSaldoConta().compareTo(transferencia);
        if (compare >= 0) {
            this.clientes[idEnviar].subSaldoConta(transferencia);
            this.clientes[idReceber].addSaldoConta(transferencia);
            System.out.println("Foi transferido R$" + transferencia + " para a conta de "
                    + this.clientes[idReceber].getNome());
        } else {
            System.out.println("Seu saldo é insuficiente");
        }
    }

    public void saque(int id, BigDecimal valor){
        System.out.println("Foi sacado R$" + valor + " da sua conta");
        this.clientes[id].subSaldoConta(valor);
    }

    public String tipoConta(int id){
        return this.clientes[id].getTipoConta();
    }
}
