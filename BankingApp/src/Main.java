import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        Bank myING = new Bank("ING");
        System.out.println("Welcome to our bank!");

        boolean loggedIn = false;
        String customerName = null;

        while (true) {
            while (!loggedIn) {
                System.out.println("""
                        If you're our customer, press 1 to login
                        If you're a new customer, press 2 to create account""");
                String a = myScanner.nextLine();
                switch (a) {
                    case "1" -> {
                        System.out.print("Enter your name: ");
                        customerName = myScanner.nextLine().trim();
                        if (myING.getCustomer(customerName) != null) {
                            loggedIn = true;
                            System.out.println("You're logged in as: " + customerName);
                        } else {
                            System.out.printf("Customer (%s) wasn't found %n", customerName);
                        }
                    }
                    case "2" -> {
                        System.out.print("Enter your name: ");
                        String name = myScanner.nextLine().trim();
                        myING.addCustomer(name);
                    }
                }
            }
            myING.printOptions();
            String input = myScanner.nextLine();
            switch (input) {
                case "1" -> {
                    for (int i = 0; i < myING.getCustomers().size(); i++) {
                        if (myING.getCustomers().get(i).getName().
                                contains(customerName)) {
                            System.out.print("Enter the amount: ");
                            double d = Double.parseDouble(myScanner.nextLine());
                            myING.addTransaction(customerName, d);
                            System.out.println(myING.getCustomers().get(i).getTransactions());
                        }
                    }
                }
                case "2" -> {
                    myING.printStatement(customerName);
                }
                case "3" -> {
                    loggedIn = false;
                    System.out.println("You were successfully logged out.");
                }
                case "4" -> {
                    loggedIn = false;
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid value. Try again.");
            }
        }
    }
}
