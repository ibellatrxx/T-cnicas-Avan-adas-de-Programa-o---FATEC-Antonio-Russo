package banco;

public abstract class Conta {
	  private int numeroAgencia;
	  private int numeroConta;
	  private String tipoConta;
	  protected double saldo; //Atualização: atributo mudou para protected
	  private String nomeTitular;
	  private static int quantidadeContas = 0;

	  public Conta(int agencia, int conta, String tipo, double saldo, String titular) {
	    this.numeroAgencia = agencia;
	    this.numeroConta = conta;
	    this.tipoConta = tipo;
	    this.saldo = saldo;
	    this.nomeTitular = titular;
	    quantidadeContas++;
	  }

	  public abstract void depositar(double valor);

	  public boolean sacar(double valor) {
	    if (saldo >= valor && valor > 0) {
	      saldo -= valor;
	      return true;
	    }
	    System.out.println("Saldo Insuficiente ou valor inválido.");
	    return false;
	  }

	  public boolean transferir(Conta destino, double valor) { //Atualização: agora está chamando o método sacar
	    if (this.sacar(valor)) {
	      destino.depositar(valor);
	      return true;
	    }
	    return false;
	  }

	  public int getNumAgencia() {
	    return numeroAgencia;
	  }

	  public void setNumAgencia(int numeroAgencia) {
	    this.numeroAgencia = numeroAgencia;
	  }

	  public int getNumConta() {
	    return numeroConta;
	  }

	  public void setNumConta(int numeroConta) {
	    this.numeroConta = numeroConta;
	  }

	  public String getTipoConta() {
	    return tipoConta;
	  }

	  public void setTipoConta(String tipoConta) {
	    this.tipoConta = tipoConta;
	  }

	  public double getSaldo() {
	    return saldo;
	  }

	  public String getNomeTitular() {
	    return nomeTitular;
	  }

	  public void setNomeTitular(String nomeTitular) {
	    this.nomeTitular = nomeTitular;
	  }

	  public static int getqtdeContas() {
	    return quantidadeContas;
	  }
	}