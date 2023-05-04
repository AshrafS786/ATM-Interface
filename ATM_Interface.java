import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ATM_Interface {

    private static double balance = 1000.00;
    private static List<Transaction> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (balance < amount) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            Transaction transaction = new Transaction(new Date(), "Withdrawal", amount, balance);
            transactionHistory.add(transaction);
            System.out.println("Transaction successful!");
        }
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        balance += amount;
        Transaction transaction = new Transaction(new Date(), "Deposit", amount, balance);
        transactionHistory.add(transaction);
        System.out.println("Transaction successful!");
    }

    private static void transactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static class Transaction {
        private Date date;
        private String type;
        private double amount;
        private double balance;

        public Transaction(Date date, String type, double amount, double balance) {
            this.date = date;
            this.type = type;
            this.amount = amount;
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Date: " + date +
                    ", Type: " + type +
                    ", Amount: " + amount +
                    ", Balance: " + balance;
        }
    }
}
