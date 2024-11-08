public class CalculadorImposto {
    private double totalImpostos;

    public void registra(Tributavel t) {
        this.totalImpostos += t.getValorImposto();
    }

    public double getTotalImpostos() {
        return totalImpostos;
    }
}
