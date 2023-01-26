import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions  = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return ("Customer's name: " + this.getName() +
                "; Transactions: " + this.getTransactions());
    }
}
