package banco;

public class Teste {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(1234, 56789, 1000.0, "Bianca Soares");
        ContaPoupanca cp = new ContaPoupanca(4321, 98765, 15000.0, "Bianca Soares");

        System.out.println("------Movimentação da Conta Corrente------");
        System.out.println("Titular: " + cc.getNomeTitular());
        System.out.println("Agência: " + cc.getNumAgencia());
        System.out.println("Conta: " + cc.getNumConta());
        System.out.println("Saldo inicial: " + cc.getSaldo());
        cc.depositar(300.0);
        System.out.println("Após depósito de R$300,00: " + cc.getSaldo());
        boolean saqueSucesso = cc.sacar(100.0); //Atualização: teste de retorno do boolean
        System.out.println("Após saque de R$100,00 (com sucesso): " + cc.getSaldo() + " | Sucesso: " + saqueSucesso);
        boolean transfSucesso = cc.transferir(cp, 200.0);
        System.out.println("Após transferência de R$200,00 para Conta Poupança: ");
        System.out.println("Saldo Conta Corrente: " + cc.getSaldo());
        System.out.println("Saldo Conta Poupança: " + cp.getSaldo() + " | Sucesso: " + transfSucesso);

        System.out.println("\n------Movimentação da Conta Poupança------");
        System.out.println("Titular: " + cp.getNomeTitular());
        System.out.println("Agência: " + cp.getNumAgencia());
        System.out.println("Conta: " + cp.getNumConta());
        System.out.println("Saldo inicial: " + cp.getSaldo());
        cp.depositar(350.0);
        System.out.println("Após depósito de R$350,00: " + cp.getSaldo());

        System.out.println("\nQuantidade total de contas criadas no banco: " + Conta.getqtdeContas());

        //Atualização: testes adicionais para saldo insuficiente
        System.out.println("\nTestando saldo insuficiente...");
        boolean saqueFalha = cc.sacar(2000);
        System.out.println("Saque de 2000 em Conta Corrente (deve falhar): " + saqueFalha);
        boolean transfFalha = cc.transferir(cp, 5000);
        System.out.println("Transferência de 5000 para Conta Poupança (deve falhar): " + transfFalha);
    }
}
