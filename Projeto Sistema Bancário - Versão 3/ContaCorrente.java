public class ContaCorrente extends Conta implements Tributavel{
    public ContaCorrente(int agencia, int conta, double saldo, String titular) {
        super(agencia, conta, "Corrente", saldo, titular);
    }
 
    public boolean sacar(double valor) {
        double total = valor + 0.2;
        return super.sacar(total);
    }
 
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
    
    public double getValorImposto(){
    	return this.saldo * 0.01;
    }
}
	