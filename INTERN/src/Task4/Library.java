package Task4;

import java.util.*;
import java.io.*;

public class Library {
    private List<LibraryItem> items;
    private Map<String, Double> fines;  // Store user fines
    private static final String FILE_NAME = "library_data.ser";

    public Library() {
        this.items = new ArrayList<>();
        this.fines = new HashMap<>();
        loadData();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        saveData();
    }

    public void checkoutItem(String title, String user) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title) && !item.isBorrowed()) {
                item.borrowItem();
                System.out.println("Item checked out by " + user);
                saveData();
                return;
            }
        }
        System.out.println("Item not found or already borrowed.");
    }

    public void returnItem(String title, String user, int daysLate) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title) && item.isBorrowed()) {
                item.returnItem();
                if (daysLate > 0) {
                    double fine = daysLate * 2.0; 
                    fines.put(user, fines.getOrDefault(user, 0.0) + fine);
                    System.out.println("Late return! Fine: $" + fine);
                }
                System.out.println("Item returned by " + user);
                saveData();
                return;
            }
        }
        System.out.println("Item not found or not borrowed.");
    }

    public void searchItems(String query, String searchType) {
        for (LibraryItem item : items) {
            if (searchType.equalsIgnoreCase("title") && item.getTitle().equalsIgnoreCase(query)) {
                item.displayDetails();
            } else if (searchType.equalsIgnoreCase("author") && item.getAuthor().equalsIgnoreCase(query)) {
                item.displayDetails();
            } else if (searchType.equalsIgnoreCase("category") && item.getCategory().equalsIgnoreCase(query)) {
                item.displayDetails();
            }
        }
    }

    public void viewFines(String user) {
        System.out.println("Outstanding fines for " + user + ": $" + fines.getOrDefault(user, 0.0));
    }

    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(items);
            out.writeObject(fines);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            items = (List<LibraryItem>) in.readObject();
            fines = (Map<String, Double>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

