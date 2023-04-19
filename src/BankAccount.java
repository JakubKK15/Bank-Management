import java.util.Scanner;

public class BankAccount {
  // Necessary variables
  private final String name;
  private final String id;
  private Double balance = 0.0;
  private double previousTransactions;

  public BankAccount(String name, String id) {
    this.name = name;
    this.id = id;
  }

  // The menu that handles all the user actions.
  public void menu() {
    Scanner input = new Scanner(System.in);
    int choice;
    System.out.println("Welcome! " + name + " Your client ID: " + id);
    do {
      System.out.print("""
          1) Check Balance
          2) Deposit
          3) Withdraw
          4) Previous Transactions
          0) Exit
          """);
      System.out.println("---------------------");
      System.out.println("Choose an option: ");
      choice = input.nextInt();
      System.out.println("\n");
      switch (choice) {
        case 1 -> {
          System.out.println("---------------------");
          System.out.println("Balance: " + balance);
          System.out.println("---------------------");
        }
        case 2 -> {
          System.out.println("---------------------");
          System.out.print("Enter amount to deposit: ");
          double depositAmount = input.nextDouble();
          System.out.println("---------------------");
          deposit(depositAmount);
          System.out.println("Balance: " + balance);
        }
        case 3 -> {
          System.out.println("---------------------");
          System.out.print("Enter amount to withdraw: ");
          double withdrawalAmount = input.nextDouble();
          System.out.println("---------------------");
          withdraw(withdrawalAmount);
          System.out.println("Balance: " + balance);
        }
        case 4 -> {
          System.out.println("---------------------");
          System.out.println("Previous transaction: ");
          System.out.println("---------------------");
          getPreviousTransaction();
        }
        default -> System.out.println("Choose a correct option to proceed.");
      }
    } while (0 != choice);
    System.out.println("Thank you for using our app!");
  }

  /*
   Method to handle the depositing of funds into the account. If the amount
   is less tan 0, the deposit will not go through, and will prompt the user
   to enter the amount again.
  */
  private void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      previousTransactions = amount;
    } else {
      System.out.println("You can't deposit a negative amount.");
      System.out.println("---------------------");
    }

  }

  /*
   Method to handle the withdrawal of funds from the account. If the amount
   exceeds the current balance of the account, the method will throw an
   error and prompt the user to try withdrawing again.
  */
  private void withdraw(double amount) {
    if (amount > balance) {
      System.out.println("Bank balance insufficient.");
      System.out.println("---------------------");
    } else {
      balance -= amount;
      previousTransactions = -amount;
    }
  }

  /*
  This method stores, and shows the latest previous transaction performed. If
   the value is above 0, it assumes that a deposit has happened. If the value
    is below 0, it assumes that a withdrawal has happened. If the value
    doesn't exist. the program returns that no transaction has occurred yet.
   */
  private void getPreviousTransaction() {
    if (previousTransactions > 0) {
      System.out.println("Deposited: " + previousTransactions);
      System.out.println("---------------------");
    } else if (previousTransactions < 0) {
      System.out.println("Withdrew: " + Math.abs(previousTransactions));
      System.out.println("---------------------");
    } else {
      System.out.println("No transactions occurred.");
      System.out.println("---------------------");
    }
  }
}
