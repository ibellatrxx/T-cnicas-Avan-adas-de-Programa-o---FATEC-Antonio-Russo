public class ContaCorrente extends Conta implements Tributavel {
    public ContaCorrente(int agencia, int conta, double saldo, String titular) {
        super(agencia, conta, "Corrente", saldo, titular);
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, ValorExcedeLimiteException, ValorNaoMultiploDeVinteException {
        double valorASacar = valor + 0.2;
        super.sacar(valorASacar);
    }

    @Override
    public double getValorImposto() {
        return super.getSaldo() * 0.01;
    }
}
