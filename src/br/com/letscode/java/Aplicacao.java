package br.com.letscode.java;

import java.math.BigDecimal;
import java.util.Scanner;

public class Aplicacao {

    static Scanner read = new Scanner(System.in);
    static ContasPF contasPF = new ContasPF();
    static ContasPJ contasPJ = new ContasPJ();

    public static void main(String[] args) {

        System.out.println("\tBEM VINDO AO BANCO MEYUHAD!");
        boolean valid = true;
        do {
            int choice;
            System.out.println("\n1 - Entrar");
            System.out.println("2 - Abra a sua conta");
            System.out.println("3 - Sair");
            choice = read.nextInt();
            switch (choice) {
                case 1:
                    entrar();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 3:
                    System.out.println(">Obrigado por usar nossos servicos<");
                    valid = false;
                    break;
                default:
                    System.err.println("Digite uma opcao valida!");
                    break;
            }
        } while (valid);
    }

    public static void cadastrar(){
        System.out.println("Pessoa fisica digite: 1");
        System.out.println("Pessoa juridica digite: 2");
        int pessoa = read.nextInt();
        switch (pessoa) {
            case 1:
                abrirPF();
                break;
            case 2:
                abrirPJ();
                break;
            default:
                System.err.println("Opcao Invalida");
                break;
        }
    }

    public static void entrar(){
        System.out.println("Digite o numero da sua conta para entrar");
        int numero = read.nextInt();
        System.out.println("Pessoa fisica 'pf' digite: 1");
        System.out.println("Pessoa juridica 'pj' digite: 2");
        int pessoa = read.nextInt();
        switch (pessoa) {
            case 1:
                contaPF(numero);
                break;
            case 2:
                contaPJ(numero);
                break;
            default:
                System.err.println("Opcao Invalida");

                break;
        }
    }

    public static void abrirPF(){
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o seu nome");
        String nome = read.next();
        System.out.println("Escolha o tipo de Conta:");
        System.out.println("'CC' Conta Corrente");
        System.out.println("'CP' Conta Poupanca");
        System.out.println("'CI' Conta Investimento - Com um rendimento de 2%");
        String conta = read.next();
        if (!(conta.equalsIgnoreCase("cc") || conta.equalsIgnoreCase("cp")
                || conta.equalsIgnoreCase("ci"))) {
            System.err.println("Conta invalida, se atente as contas permitidas para PF!");
            return;
        }

        Cliente novoCliente = new Cliente(nome, "pf", conta);
        if (contasPF.adicionarConta(novoCliente)){
            System.out.println(novoCliente);
            System.out.printf("Grave as informacoes necessarias para entrar na conta\n" +
                    "Numero: %d\nPessoa: pf",contasPF.indiceConta()-1);
        }
    }

    public static void abrirPJ(){
        Scanner read = new Scanner(System.in);
        System.out.println("Digite o seu nome");
        String nome = read.next();
        System.out.println("Escolha o tipo de Conta:");
        System.out.println("'CC' Conta Corrente");
        System.out.println("'CI' Conta Investimento - Com um rendimento de 4%");
        String conta = read.next();
        if (!(conta.equalsIgnoreCase("cc") || conta.equalsIgnoreCase("ci"))) {
            System.err.println("Conta invalida, se atente as contas permitidas para PJ!");
            return;
        }
        Cliente novoCliente = new Cliente(nome, "pj", conta);
        if (contasPJ.adicionarConta(novoCliente)){
            System.out.println(novoCliente);
            System.out.printf("Grave as informacoes necessarias para entrar na conta\n" +
                    "Numero: %d\nPessoa: pj",contasPJ.indiceConta()-1);
        }
    }

    public static void contaPF(int nConta){
        System.out.println("Bem vindo!");
        boolean valid = true;
        do {
            System.out.println("1 - Consultar Saldo");
            if(contasPF.tipoConta(nConta).equalsIgnoreCase("ci")){
                System.out.println("2 - Investir");
            }
            else {
                System.out.println("2 - Depositar");
            }
            System.out.println("3 - Transferir");
            System.out.println("4 - Sacar");
            System.out.println("5 - Voltar");
            int option = read.nextInt();

            if (option == 1) {
                System.out.println(">>> Consultando saldo");
                if (contasPF.tipoConta(nConta).equalsIgnoreCase("ci")){
                    contasPF.retornaSaldoInvestimento(nConta);
                }
                else {
                    contasPF.retornaSaldo(nConta);
                }
            }

            if (option == 2) {
                System.out.println("Digite o Valor:");
                BigDecimal valor = read.nextBigDecimal();
                contasPF.depositar(nConta,valor);
            }

            if (option == 3) {
                System.out.println("Lembrando que voce pode transferir apenas para pessoas fisicas");
                System.out.println("Digite o numero da conta que deseja transferir");
                int nTransferencia = read.nextInt();
                System.out.println("Digite o Valor que deseja transferir");
                BigDecimal valor = read.nextBigDecimal();
                contasPF.transferir(nConta,nTransferencia,valor);
            }

            if (option == 4) {
                System.out.println("Digite o valor que deseja sacar");
                BigDecimal valor = read.nextBigDecimal();
                contasPF.saque(nConta,valor);
            }
            if (option == 5) {
                System.out.println(">>> voltando");
                valid = false;
            }
        } while (valid);
    }

    public static void contaPJ(int nConta){
        System.out.println("Bem vindo!");
        boolean valid = true;
        do {
            System.out.println("1 - Consultar Saldo");
            if(contasPJ.tipoConta(nConta).equalsIgnoreCase("ci")){
                System.out.println("2 - Investir");
            }
            else {
                System.out.println("2 - Depositar");
            }
            System.out.println("3 - Transferir");
            System.out.println("4 - Sacar");
            System.out.println("5 - Voltar");
            int option = read.nextInt();

            if (option == 1) {
                System.out.println(">>> Consultando saldo");
                if (contasPF.tipoConta(nConta).equalsIgnoreCase("ci")){
                    contasPJ.retornaSaldoInvestimento(nConta);
                }
                else {
                    contasPJ.retornaSaldo(nConta);
                }
            }
            if (option == 2) {
                System.out.println("Digite o Valor:");
                BigDecimal valor = read.nextBigDecimal();
                contasPJ.depositar(nConta,valor);
            }
            if (option == 3) {
                System.out.println("Lembrando que voce pode transferir apenas para pessoas fisicas");
                System.out.println("Digite o numero da conta que deseja transferir");
                int nTransferencia = read.nextInt();
                System.out.println("Digite o Valor que deseja transferir");
                BigDecimal valor = read.nextBigDecimal();
                contasPJ.transferir(nConta,nTransferencia,valor);
            }
            if (option == 4) {
                System.out.println("Digite o valor que deseja sacar");
                BigDecimal valor = read.nextBigDecimal();
                contasPJ.saque(nConta,valor);
            }
            if (option == 5) {
                System.out.println(">>> voltando");
                valid = false;
            }
        } while (valid);
    }
}
