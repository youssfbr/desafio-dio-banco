package app;

import entities.*;

public class Main {
    public static void main(String[] args) {

        final Banco banco = new Banco();
        banco.setNome("Banco da DIO");

        final Cliente alisson = new Cliente();
        alisson.setNome("Alisson");

        final Conta cc = new ContaCorrente(alisson);
        final Conta cp = new ContaPoupanca(alisson);

        cc.depositar(100);
        cc.transferir(cp, 90);

        System.out.println("=== Banco: " + banco.getNome() + " ===");
        System.out.println("===");
        cc.imprimirExtrato();
        System.out.println();
        cp.imprimirExtrato();

        banco.getContas().add(cc);
        banco.getContas().add(cp);

        System.out.println();
        System.out.println("====================================");
        System.out.println();
        System.out.println("=== Todas as contas ===");

        System.out.println();
        for (Conta s : banco.getContas()) {
            s.imprimirExtrato();
        }
    }
}
