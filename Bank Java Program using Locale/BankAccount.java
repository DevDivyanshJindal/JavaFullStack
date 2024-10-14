import java.util.*;
import java.text.MessageFormat;

public class BankAccount {
    private double balance;
    private final double MINIMUM_BALANCE = 2000.0;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance(ResourceBundle bundle) {
        System.out.println(MessageFormat.format(bundle.getString("current.balance"), balance));
    }

    public void deposit(double amount, ResourceBundle bundle) {
        balance += amount;
        System.out.println(MessageFormat.format(bundle.getString("deposit.success"), amount, balance));
    }

    public void withdraw(double amount, ResourceBundle bundle) {
        if (balance - amount >= MINIMUM_BALANCE) {
            balance -= amount;
            System.out.println(MessageFormat.format(bundle.getString("withdraw.success"), amount, balance));
        } else if (balance < amount) {
            System.out.println(bundle.getString("withdraw.fail"));
        } else {
            System.out.println(bundle.getString("withdraw.fail.minimum"));
        }
    }

    public static void main(String[] args) {
        ResourceBundle bundle;
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Press 1 for Hindi, 2 for English, 3 for Japanese:");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
                bundle = ResourceBundle.getBundle("ResourceBundle", new Locale("hi", "IN"));
                break;
            case 2:
                bundle = ResourceBundle.getBundle("ResourceBundle", new Locale("en", "US"));
                break;
            case 3:
                bundle = ResourceBundle.getBundle("ResourceBundle", new Locale("ja", "JP"));
                break;
            default:
                System.out.println("Invalid option. Defaulting to English.");
                bundle = ResourceBundle.getBundle("ResourceBundle", new Locale("en", "US"));
                break;
        }

        
        BankAccount account = new BankAccount(2000.0);

        int option;
        do {
           
            System.out.println(bundle.getString("menu"));
            option = sc.nextInt();
            sc.nextLine(); 

            switch (option) {
                case 1:
                    account.checkBalance(bundle);
                    break;
                case 2:
                    System.out.println(bundle.getString("enter.deposit"));
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount, bundle);
                    break;
                case 3:
                    System.out.println(bundle.getString("enter.withdraw"));
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount, bundle);
                    break;
                case 4:
                    System.out.println(bundle.getString("goodbye"));
                    break;
                default:
                    System.out.println(bundle.getString("invalid.option"));
            }
        } while (option != 4);

        sc.close();
    }
}

