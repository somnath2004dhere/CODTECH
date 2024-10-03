package Task5;

import java.io.*;
import java.util.*;

public class Bank {
	
	
    private Map<String, BankAccount> accounts;
    
    
    private static final String FILE_NAME = "bank_data.ser";

    public Bank() {
        accounts = new HashMap<>();
        loadData();
    }

    public void createAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account with number already exists.");
        } else {
            BankAccount account = new BankAccount(accountNumber, accountHolderName, initialDeposit);
            accounts.put(accountNumber, account);
            saveData();
            System.out.println("Account created successfully");
        }
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            saveData();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            saveData();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        BankAccount fromAccount = accounts.get(fromAccountNumber);
        BankAccount toAccount = accounts.get(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            fromAccount.transfer(toAccount, amount);
            saveData();
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void viewTransactionHistory(String accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.viewTransactionHistory();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void updateAccountHolderName(String accountNumber, String newName) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.updateAccountHolderName(newName);
            saveData();
        } else {
            System.out.println("Account not found.");
        }
    }

    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (Map<String, BankAccount>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

