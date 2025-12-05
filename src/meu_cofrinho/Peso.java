package meu_cofrinho;

// Peso do pais do Mexico.
public class Peso extends Moeda {

    // Cotação fixa do Peso para Real.
    private static final double COTACAO_BRL = 0.30;

    public Peso(double quantia) {
        super(quantia);
    }

   
    @Override
    public String getInfo() {
        return "Peso (MXN) --- Valor: " + this.quantia;
    }

    // A conversão multiplica a quantia pela cotação.
    @Override
    public double converterParaReais() {
        return this.quantia * COTACAO_BRL;
    }
}