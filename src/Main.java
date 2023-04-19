import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Ask the user for their name and customer ID
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your Name and Customer ID to access your " +
        "account.");
    String name = input.nextLine();
    String id = input.nextLine();

    // Create an account based on the input provided by the user
    BankAccount account = new BankAccount(name, id);
    account.menu();
  }
}