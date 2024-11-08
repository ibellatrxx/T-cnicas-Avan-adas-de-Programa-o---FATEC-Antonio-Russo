public abstract class Conta {
    private String numeroAgencia;
    private String numeroConta;
    private String tipoConta;
    private double saldo;
    private String nomeTitular;

    public Conta(String numeroAgencia, String numeroConta, String tipoConta, double saldo, String nomeTitular) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.setSaldo(saldo);
        this.nomeTitular = nomeTitular;
    }

	public String getnumeroAgencia() {
        return numeroAgencia;
    }
	public void setnumeroAgencia(String numeroAgencia) {
    	this.numeroAgencia = numeroAgencia;
    }
	
    public String getnumeroConta() {
        return numeroConta;
    }
    public void setnumeroConta(String numeroConta) {
    	this.numeroConta = numeroConta;
    }

  
    public String gettipoConta() {
        return tipoConta;
    }
    public void settipoConta(String tipoConta) {
    	this.tipoConta = tipoConta;
    }

    
    
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
    

    public String getnomeTitular() {
        return nomeTitular;
    }
    public void setnomeTitular(String nomeTitular) {
    	this.nomeTitular = nomeTitular;
    }

    
    public abstract void depositar(double valor);

    public abstract boolean sacar(double valor);

    public abstract boolean transferir(Conta destino, double valor);

    public abstract void consultar();

	
}
