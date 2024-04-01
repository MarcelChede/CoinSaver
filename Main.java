import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PiggyBank piggyBank = new PiggyBank();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add coin");
            System.out.println("2. Remove coin");
            System.out.println("3. List coins");
            System.out.println("4. Calculate total in Brazilian Reais");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Choose the coin (1 - Dollar, 2 - Euro, 3 - Real): ");
                    int coinType = scanner.nextInt();
                    System.out.println("Enter the coin value: ");
                    double coinValue = scanner.nextDouble();
                    switch (coinType) {
                        case 1:
                            piggyBank.addCoin(new Dollar(coinValue));
                            break;
                        case 2:
                            piggyBank.addCoin(new Euro(coinValue));
                            break;
                        case 3:
                            piggyBank.addCoin(new BrazilianReal(coinValue));
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the index of the coin to be removed: ");
                    int index = scanner.nextInt();
                    piggyBank.removeCoin(index - 1);
                    break;
                case 3:
                    piggyBank.listCoins();
                    break;
                case 4:
                    System.out.println("Total in Brazilian Reais in the piggy bank: "
                            + piggyBank.calculateTotalInBrazilianReais());
                    break;
                case 5:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
