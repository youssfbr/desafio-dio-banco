package interfaces;

import entities.Conta;

public interface IConta {
    boolean sacar(double valor);
    void depositar(double valor);
    void transferir(Conta contaDestino, double valor);
    void imprimirExtrato();
}
