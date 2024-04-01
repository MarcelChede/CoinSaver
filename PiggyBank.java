import java.util.ArrayList;

abstract class Coin {

    protected double value;

    public Coin(double value) {
        this.value = value;
    }

    public abstract double getValueInBrazilianReal();
}

// Real coin class
class BrazilianReal extends Coin {

    public BrazilianReal(double value) {
        super(value);
    }

    @Override
    public double getValueInBrazilianReal() {
        return value * 1; // Conversion rate: 1 to 1, in Brazilian Real
    }
}

// Dollar coin class
class Dollar extends Coin {

    public Dollar(double value) {
        super(value);
    }

    @Override
    public double getValueInBrazilianReal() {
        return value * 5.25; // Conversion rate: 1 dollar = 5.25 Brazilian Reais
    }
}

// Euro coin class
class Euro extends Coin {

    public Euro(double value) {
        super(value);
    }

    @Override
    public double getValueInBrazilianReal() {
        return value * 6.15; // Conversion rate: 1 euro = 6.15 Brazilian Reais
    }
}

// Class representing the piggy bank
class PiggyBank {

    private ArrayList<Coin> coins;

    public PiggyBank() {
        coins = new ArrayList<>();
    }

    // Method to add coins to the piggy bank
    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    // Method to remove coins from the piggy bank
    public void removeCoin(int index) {
        if (index >= 0 && index < coins.size()) {
            coins.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to list all coins in the piggy bank
    public void listCoins() {
        System.out.println("Coins in the piggy bank:");
        for (int i = 0; i < coins.size(); i++) {
            Coin coin = coins.get(i);
            System.out.println("Coin " + (i + 1) + ": " + coin.getClass().getSimpleName() + " - Value: "
                    + coin.getValueInBrazilianReal() + " Brazilian Reais");
        }
    }

    // Method to calculate the total money in the piggy bank in Brazilian Reais
    public double calculateTotalInBrazilianReais() {
        double total = 0;
        for (Coin coin : coins) {
            total += coin.getValueInBrazilianReal();
        }
        return total;
    }
}
