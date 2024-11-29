public class ContaPoupanca extends Conta {
    public ContaPoupanca(int agencia, int conta, double saldo, String titular) {
        super(agencia, conta, "Poupança", saldo, titular);
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }  
}
