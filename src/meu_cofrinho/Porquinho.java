package meu_cofrinho;

// Importa a estrutura de dados para armazenar as moedas.
import java.util.ArrayList;

// Esta classe gerencia a coleção de moedas.
public class Porquinho {

    // Esta lista armazena todas as moedas inseridas no porquinho,
// independentemente do tipo específico (Real, Iene, Libra, Peso, etc.).
    private ArrayList<Moeda> itens;

    // O construtor inicializa a lista de itens.
    public Porquinho() {
        this.itens = new ArrayList<>();
    }

    // Método que adiciona um novo item "moeda" ao porquinho.
    public void guardar(Moeda item) {
        this.itens.add(item);
        System.out.println("Moeda guardada no porquinho.");
    }

    // Método responsável por remover uma moeda da lista.
// A remoção funciona porque a classe Moeda sobrescreve o método equals,
// permitindo identificar a moeda certa pelo tipo e pelo valor informado.
    public void retirar(Moeda itemParaExcluir) {
        boolean sucessoNaRemocao = this.itens.remove(itemParaExcluir);

        if (sucessoNaRemocao) {
            System.out.println("Moeda retirada com sucesso.");
        } else {
            System.out.println("Não foi possível encontrar essa moeda (tipo e valor exatos).");
        }
    }

    // Método para mostrar todos os itens guardados.
    public void exibirItens() {
        // Verifica se o porquinho está vazio.
        if (this.itens.isEmpty()) {
            System.out.println("Não há moedas aqui dentro.");
            return;
        }
        
        System.out.println("\n+++ Conteúdo do Porquinho +++");
        
    
        for (Moeda item : this.itens) {
            System.out.println(item.getInfo());
        }
        System.out.println("+++++++++++++++++++++++++++++");
    }

    // Método para somar o valor de todas as moedas, convertendo para BRL.
    public double calcularValorTotalEmReais() {
        double acumulador = 0;

        // O método .converterParaReais() chamado também é o da
         //subclasse específica.

        for (Moeda item : this.itens) {
            acumulador = acumulador + item.converterParaReais();
        }
        
        return acumulador;
    }
}