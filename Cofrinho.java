import java.util.ArrayList;

abstract class Moeda {

    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public abstract double getValorEmReal();
}

//Classe moeda Real
class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public double getValorEmReal() {
        return valor * 1; //Taxa de conversão: 1 p 1, em real
    }
}

//Classe para moeda Dólar
class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public double getValorEmReal() {
        return valor * 5.25; //Taxa de conversão, 1 dólar = 5.25 reais
    }
}

//Classe moeda Euro
class Euro extends Moeda {

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public double getValorEmReal() {
        return valor * 6.15; //Taxa de conversão, 1 euro = 6.15 reais
    }
}

//Classe que representa o cofrinho
class Cofrinho {

    private ArrayList<Moeda> moedas;

    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    //Método para adicionar moedas ao cofrinho
    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
    }

    //Método para remover moedas do cofrinho
    public void removerMoeda(int indice) {
        if (indice >= 0 && indice < moedas.size()) {
            moedas.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    //Método para listar todas as moedas do cofrinho
    public void listarMoedas() {
        System.out.println("Moedas no cofrinho:");
        for (int i = 0; i < moedas.size(); i++) {
            Moeda moeda = moedas.get(i);
            System.out.println("Moeda " + (i + 1) + ": " + moeda.getClass().getSimpleName() + " - Valor: "
                    + moeda.getValorEmReal() + " reais");
        }
    }

    //Método para calcular o total de dinheiro no cofrinho em reais
    public double calcularTotalEmReais() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.getValorEmReal();
        }
        return total;
    }
}
