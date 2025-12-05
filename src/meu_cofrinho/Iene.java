package meu_cofrinho;

// Iene moeda japonesa
public class Iene extends Moeda {

    // Cotação  do Iene para Real.
    private static final double COTACAO_BRL = 0.04;

    public Iene(double quantia) {
        super(quantia);
    }

   
    @Override
    public String getInfo() {
        return "Iene (JPY) --- Valor: " + this.quantia;
    }

    // conversão multiplica a quantia pela cotação.
    @Override
    public double converterParaReais() {
        return this.quantia * COTACAO_BRL;
    }
}