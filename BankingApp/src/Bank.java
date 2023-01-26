import java.util.ArrayList;

public class Bank {

    private Customer customer;
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public Customer getCustomer(String customerName) {
        for (var customer : customers) {
            if (customer.getName().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }
        return null;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(String customerName) {
        if (getCustomer(customerName) == null) {
            Customer newCustomer = new Customer(customerName);
            customers.add(newCustomer);
            System.out.println("Created a new customer: " + customerName);
        }
    }

    public void addTransaction(String customerName, double transactionAmount) {
        Customer customer = getCustomer(customerName);
        if (customer != null) {
            customer.getTransactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName) {

        Customer customer = getCustomer(customerName);
        if (customer == null) {
            return;
        }
        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Transactions:");
        for (double d : customer.getTransactions()) {
            System.out.printf("%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }

    public void printOptions() {
        System.out.print("""
                
                What would you like to do?
                Press 1 to add a transaction
                Press 2 to show transactions
                Press 3 to log out
                Press 4 to quit app
                """);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "customer=" + customer +
                ", name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
