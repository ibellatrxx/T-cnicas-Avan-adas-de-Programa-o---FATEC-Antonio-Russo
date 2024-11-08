public class ContaPoupanca extends Conta {
    public ContaPoupanca(String numeroAgencia, String numeroConta, double saldo, String nomeTitular) {
        super(numeroAgencia, numeroConta, "Poupança", saldo, nomeTitular);
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito realizado.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && this.getSaldo() - valor >= 0) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque realizado.");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false;
        }
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência realizada.");
            return true;
        } else {
            System.out.println("Transferência não realizada.");
            return false;
        }
    }

    @Override
    public void consultar() {
        System.out.println("Saldo Poupança atual: " + this.getSaldo());
    }
}
