package meu_cofrinho;

//classe geral para todas as moedas.
 
public abstract class Moeda {

    // Atributo que armazena o valor  da moeda.
    // "protected" permite que as classes filhas tenham acesso
    protected double quantia;

    // Construtor que exige um valor ao criar qualquer moeda.
    public Moeda(double quantia) {
        this.quantia = quantia;
    }

   
    public abstract String getInfo();
    public abstract double converterParaReais();

    /*
     *Método 'equals'
     *Eessencial para o método 'remover' do porquinho funcionar.
     *Duas moedas são consideradas 'iguais' se pertencerem à mesma classe
     *E tiverem o mesmo valor.
     */
    @Override
    public boolean equals(Object obj) {
        // Verifica se o objeto sendo comparado é nulo.
        if (obj == null) {
            return false;
        }
        
        // Verifica se os objetos são de classes diferentes (ex: real vs peso).
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        // Converte o obj para Moeda para acessar a quantia
        Moeda outra = (Moeda) obj;

        // Retorna verdadeiro somente se as quantias forem idênticas.
        return this.quantia == outra.quantia;
    }
}