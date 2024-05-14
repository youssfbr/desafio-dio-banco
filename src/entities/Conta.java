package entities;

import interfaces.IConta;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Banco banco;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        agencia = Conta.AGENCIA_PADRAO;
        numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor < 0) {
            System.out.println();
            System.out.println("O valor não pode ser um número negativo.");
            System.out.println();

            return false;
        }
        else if (valor > saldo) {
            System.out.println();
            System.out.println("Não é possível sacar! Saldo insuficiente!");
            System.out.println();

            return false;
            }
            else {
                saldo -= valor;

                System.out.println();
                System.out.println(String.format("Transferência de %.2f executada com sucesso!", valor));
                System.out.println();

                return true;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino , double valor) {
        final boolean sacar = this.sacar(valor);

        if (sacar) {
            contaDestino.depositar(valor);
        }
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Conta: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
