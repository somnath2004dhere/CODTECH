package Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOnline Banking System:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transaction History");
            System.out.println("6. Update Account Holder Name");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter account number: ");
                    
                    String accountNumber = scanner.nextLine();
                    
                    System.out.println("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.println("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    bank.createAccount(accountNumber, accountHolderName, initialDeposit);
                    break;
                case 2:
                    System.out.println("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositAccountNumber, depositAmount);
                    break;
                case 3:
                    System.out.println("Enter account number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    System.out.println("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(withdrawAccountNumber, withdrawAmount);
                    break;
                case 4:
                    System.out.println("Enter your account number: ");
                    String fromAccount = scanner.nextLine();
                    System.out.println("Enter recipient account number: ");
                    String toAccount = scanner.nextLine();
                    System.out.println("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    bank.transfer(fromAccount, toAccount, transferAmount);
                    break;
                case 5:
                    System.out.println("Enter account number: ");
                    String historyAccountNumber = scanner.nextLine();
                    bank.viewTransactionHistory(historyAccountNumber);
                    break;
                case 6:
                    System.out.println("Enter account number: ");
                    String updateAccountNumber = scanner.nextLine();
                    System.out.println("Enter new account holder name: ");
                    String newName = scanner.nextLine();
                    bank.updateAccountHolderName(updateAccountNumber, newName);
                    break;
                case 7:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

