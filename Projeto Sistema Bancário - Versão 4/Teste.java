public class Teste {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(1234, 56789, 1000.0, "Bianca Soares");
        ContaPoupanca cp = new ContaPoupanca(4321, 98765, 15000.0, "Bianca Soares");

        SeguroDeVida seguro = new SeguroDeVida(); 
        CalculadorImposto calc = new CalculadorImposto();

        System.out.println("Quantidade total de contas criadas no banco: " + Conta.getqtdeContas());

        System.out.println("\n------Movimentação da Conta Corrente------");
        System.out.println("Titular: " + cc.getNomeTitular());
        System.out.println("Agência: " + cc.getNumAgencia());
        System.out.println("Conta: " + cc.getNumConta());
        System.out.println("Saldo inicial: " + cc.getSaldo());
        cc.depositar(300.0);
        System.out.println("Após depósito de R$300,00: " + cc.getSaldo());

        // Testando saques e verificando exceções
        try {
            cc.sacar(100.0); // Saque com sucesso
            System.out.println("Após saque de R$100,00 (com sucesso): " + cc.getSaldo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            cc.sacar(350.0); // Teste para saque acima do limite
        } catch (Exception e) {
            System.out.println("Tentativa de saque de R$350,00: " + e.getMessage());
        }

        try {
            cc.sacar(30.0); // Teste para saque não múltiplo de R$20
        } catch (Exception e) {
            System.out.println("Tentativa de saque de R$30,00: " + e.getMessage());
        }

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

        System.out.println("\n\n------Testando saldo insuficiente------");
        try {
            cc.sacar(2000); // Teste para saldo insuficiente
        } catch (Exception e) {
            System.out.println("Saque de R$2000,00 em Conta Corrente (deve falhar): " + e.getMessage());
        }

        boolean transfFalha = cc.transferir(cp, 5000);
        System.out.println("Transferência de R$5000,00 para Conta Poupança (deve falhar):" + transfFalha);

        calc.registra(cc); // Registra imposto da Conta Corrente
        calc.registra(seguro); // Registra imposto do Seguro de Vida

        System.out.println("\n\n------Impostos Contabilizados------");
        // Testando os valores e a soma dos impostos
        System.out.println("Imposto Conta Corrente: " + cc.getValorImposto());
        System.out.println("Imposto Seguro de Vida: " + seguro.getValorImposto());
        System.out.println("Total de Impostos Arrecadados: " + calc.getTotalImpostos());
    }
}
