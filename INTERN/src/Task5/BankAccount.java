package Task5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Serializable {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial deposit: $" + initialDeposit);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: $" + amount);
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrew: $" + amount);
            System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }

    public void transfer(BankAccount toAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            addTransaction("Transferred: $" + amount + " to Account: " + toAccount.getAccountNumber());
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction history for " + accountHolderName + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private void addTransaction(String transactionDetail) {
        transactionHistory.add(transactionDetail);
    }

    public void updateAccountHolderName(String newName) {
        this.accountHolderName = newName;
        addTransaction("Account holder name updated to: " + newName);
    }
}

