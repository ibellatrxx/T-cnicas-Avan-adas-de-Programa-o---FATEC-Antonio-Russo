public class Teste {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("001", "12345-6", 1000.0, "Bianca");
        ContaPoupanca cp = new ContaPoupanca("001", "98765-4", 500.0, "Bianca");

        
        System.out.println("Titular da Conta: " + cc.getnomeTitular());
        System.out.println("Número Agência: " + cc.getnumeroAgencia());
        System.out.println("Número Conta: " + cc.getnumeroConta());
        System.out.println("Tipo da Conta: " + cc.gettipoConta());
        System.out.println("Saldo: " + cc.getSaldo());
        cc.depositar(500.0);
        cc.sacar(200.0);
        cc.consultar(); 
        
        
        System.out.println("\nTitular da Conta: " + cp.getnomeTitular());
        System.out.println("Número Agência: " + cp.getnumeroAgencia());
        System.out.println("Número Conta: " + cp.getnumeroConta());
        System.out.println("Tipo da Conta: " + cp.gettipoConta());
        System.out.println("Saldo: " + cp.getSaldo());
        cp.depositar(200.0);
        cp.transferir(cc, 100.0);
        cp.consultar();
        cc.consultar();
        
    }
}
