public abstract class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private String tipoConta;
    protected double saldo; 
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

    public void sacar(double valor) throws SaldoInsuficienteException, ValorExcedeLimiteException, ValorNaoMultiploDeVinteException {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }
        if (valor > 300) {
            throw new ValorExcedeLimiteException("Valor de saque superior ao limite máximo.");
        }
        if (valor % 20 != 0) {
            throw new ValorNaoMultiploDeVinteException("Valor do saque não pode ser composto por cédulas de R$20.");
        }
        this.saldo -= valor;
    }

    public boolean transferir(Conta destino, double valor) {
        try {
            this.sacar(valor);
            destino.depositar(valor);
            return true;
        } catch (SaldoInsuficienteException | ValorExcedeLimiteException | ValorNaoMultiploDeVinteException e) {
            System.out.println(e.getMessage());
            return false;
        }
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

