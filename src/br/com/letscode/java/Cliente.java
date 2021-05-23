package br.com.letscode.java;

import java.math.BigDecimal;

public class Cliente {
    private String nome;
    private String tipoPessoa;
    private String tipoConta;
    private BigDecimal saldoConta;


    public Cliente(String nome, String tipoPessoa, String tipoConta) {
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.tipoConta = tipoConta;
        this.saldoConta = new BigDecimal("0");
    }

    public String getNome() {
        return nome;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public BigDecimal getSaldoConta() {
        return saldoConta;
    }

    public void addSaldoConta(BigDecimal valor) {
        this.saldoConta = this.saldoConta.add(valor);
    }

    public void subSaldoConta(BigDecimal valor) {
        this.saldoConta = this.saldoConta.subtract(valor);
    }

    public String toString() {
        return "Nome do Cliente: " + this.nome + "\n" +
                "Tipo de pessoa: " + this.tipoPessoa + "\n" +
                "Tipo de conta: " + this.tipoConta+ "\n" +
                "Saldo em conta: R$" + this.saldoConta;
    }
}