package meu_cofrinho;

// Importa o Scanner para ler a entrada do usuário
// e o InputMismatchException para tratar erros de sintaxe
import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {

    
    private Scanner leitorEntrada;
    private Porquinho meuPorquinho;

    // Construtor da classe Principal: inicializa os atributos.
    public Principal() {
        this.leitorEntrada = new Scanner(System.in);
        this.meuPorquinho = new Porquinho();
    }

    public static void main(String[] args) {
        // Cria uma instância da própria classe para rodar o menu.
        Principal programa = new Principal();
        programa.iniciarInterface();
    }

    // Método principal que controla o loop do menu.
    public void iniciarInterface() {
        int escolhaUsuario = -1;

        // O loop continua até que o usuário escolha '0'.
        while (escolhaUsuario != 0) {
            System.out.println("\n-*** MEU PORQUINHO DIGITAL ***-");
            System.out.println("1. Depositar nova moeda");
            System.out.println("2. Retirar uma moeda");
            System.out.println("3. Verificar moedas armazenadas");
            System.out.println("4. Mostrar valor total em BRL");
            System.out.println("0. Sair do sistema");
            System.out.print("Escolha uma operação: ");

            try {
                // Tenta ler o número da escolha
                escolhaUsuario = leitorEntrada.nextInt();

                // Direciona a ação com base na escolha
                switch (escolhaUsuario) {
                    case 1:
                        menuAdicao();
                        break;
                    case 2:
                        menuRemocao();
                        break;
                    case 3:
                        meuPorquinho.exibirItens();
                        break;
                    case 4:
                        double valorTotalCalculado = meuPorquinho.calcularValorTotalEmReais();
                        System.out.printf("O valor total no porquinho é: R$ %.2f\n", valorTotalCalculado);
                        break;
                    case 0:
                        System.out.println("Até logo! Fechando o porquinho.");
                        break;
                    default:
                        System.out.println("Escolha não reconhecida. Use um número do menu.");
                        break;
                }
            } catch (InputMismatchException e) {
                // Tratamento de erro se o usuário digitar letras.
                System.out.println("Falha na leitura. Digite apenas números.");
                leitorEntrada.next(); // Limpa o buffer do scanner.
                escolhaUsuario = -1;  // Força o loop a continuar.
            }
        }
        
        // Fecha o recurso do scanner ao terminar o programa.
        leitorEntrada.close();
    }

    // Submenu para adicionar moedas.
    private void menuAdicao() {
        System.out.println("\nQual moeda deseja depositar?");
        System.out.println("1. Real (BRL)");
        System.out.println("2. Libra (GBP)");
        System.out.println("3. Iene (JPY)");
        System.out.println("4. Peso (MXN)");

        int tipoDeMoeda = leitorEntrada.nextInt();

        System.out.print("Qual a quantia (ex: 44.44): ");
        double valorDaMoeda = leitorEntrada.nextDouble();

        // Cria a instância da moeda correta.
        Moeda novaMoeda = null;
        switch (tipoDeMoeda) {
            case 1:
                novaMoeda = new Real(valorDaMoeda);
                break;
            case 2:
                novaMoeda = new Libra(valorDaMoeda);
                break;
            case 3:
                novaMoeda = new Iene(valorDaMoeda);
                break;
            case 4:
                novaMoeda = new Peso(valorDaMoeda);
                break;
            default:
                System.out.println("Tipo de moeda não existe.");
                return; // Volta ao menu principal.
        }

        // Guarda a moeda criada no porquinho.
        meuPorquinho.guardar(novaMoeda);
    }

    // Submenu para remover moedas.
    private void menuRemocao() {
        System.out.println("\nQual moeda deseja RETIRAR?");
        System.out.println("1. Real (BRL)");
        System.out.println("2. Libra (GBP)");
        System.out.println("3. Iene (JPY)");
        System.out.println("4. Peso (MXN)");

        int tipoDeMoeda = leitorEntrada.nextInt();

        System.out.print("Qual a quantia (ex: 14.24): ");
        double valorDaMoeda = leitorEntrada.nextDouble();

        // Cria um modelo da moeda a ser removida.
        Moeda modeloMoedaParaRemover = null;
        switch (tipoDeMoeda) {
            case 1:
                modeloMoedaParaRemover = new Real(valorDaMoeda);
                break;
            case 2:
                modeloMoedaParaRemover = new Libra(valorDaMoeda);
                break;
            case 3:
                modeloMoedaParaRemover = new Iene(valorDaMoeda);
                break;
            case 4:
                modeloMoedaParaRemover = new Peso(valorDaMoeda);
                break;
            default:
                System.out.println("Tipo de moeda não existe.");
                return; // Volta ao menu principal.
        }

        // Tenta retirar a moeda do porquinho.
        meuPorquinho.retirar(modeloMoedaParaRemover);
    }
}