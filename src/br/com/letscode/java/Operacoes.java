package br.com.letscode.java;

import java.math.BigDecimal;

public interface Operacoes {

    Boolean adicionarConta(Cliente novoCliente);

    void retornaSaldo(int id);

    void depositar(int id, BigDecimal deposito);

    void transferir(int idEnviar, int idReceber, BigDecimal transferencia);

    void saque(int id, BigDecimal valor);

}