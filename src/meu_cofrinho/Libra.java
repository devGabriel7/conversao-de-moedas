package meu_cofrinho;

// Libra
public class Libra extends Moeda {

    // Cotação Libra para Real.
    private static final double COTACAO_BRL = 6.50;

    public Libra(double quantia) {
        super(quantia);
    }

    
    @Override
    public String getInfo() {
        return "Libra (GBP) --- Valor: " + this.quantia;
    }

    // A conversão multiplica a quantia pela cotação.
    @Override
    public double converterParaReais() {
        return this.quantia * COTACAO_BRL;
    }
}