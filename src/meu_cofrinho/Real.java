package meu_cofrinho;


public class Real extends Moeda {

    // O construtor de Real apenas chama o construtor da classe mãe (Moeda).
    public Real(double quantia) {
        super(quantia);
    }

    
    @Override
    public String getInfo() {
        return "Real (BRL) --- Valor: " + this.quantia;
    }

    // conversão, 1 real vale 1 real.
    @Override
    public double converterParaReais() {
        return this.quantia;
    }
}