import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Somar total em reais");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha a moeda (1 - Dólar, 2 - Euro, 3 - Real): ");
                    int tipoMoeda = scanner.nextInt();
                    System.out.println("Digite o valor da moeda: ");
                    double valorMoeda = scanner.nextDouble();
                    switch (tipoMoeda) {
                        case 1:
                            cofrinho.adicionarMoeda(new Dolar(valorMoeda));
                            break;
                        case 2:
                            cofrinho.adicionarMoeda(new Euro(valorMoeda));
                            break;
                        case 3:
                            cofrinho.adicionarMoeda(new Real(valorMoeda));
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o índice da moeda a ser removida: ");
                    int indice = scanner.nextInt();
                    cofrinho.removerMoeda(indice - 1);
                    break;
                case 3:
                    cofrinho.listarMoedas();
                    break;
                case 4:
                    System.out.println("Total em reais no cofrinho: " + cofrinho.calcularTotalEmReais());
                    break;
                case 5:
                    System.out.println("Saiu");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}