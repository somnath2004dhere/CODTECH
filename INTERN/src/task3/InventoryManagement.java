package task3;

import java.util.*;
import java.io.*;

public class InventoryManagement {
    private List<Product> products;
    private static final String FILE_NAME = "inventory_data.ser";

    public InventoryManagement() {
        products = new ArrayList<>();
        loadData();
    }

    public void addProduct(Product product) {
        products.add(product);
        saveData();
    }

    public void editProduct(String productId, String productName, double price, int quantity) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                product.setQuantity(quantity);
                saveData();
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct(String productId) {
        products.removeIf(product -> product.getProductId().equals(productId));
        saveData();
        System.out.println("Product deleted successfully.");
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product product : products) {
            product.displayProduct();
        }
    }

    public void lowStockReport(int threshold) {
        System.out.println("Low Stock Report:");
        for (Product product : products) {
            if (product.getQuantity() <= threshold) {
                product.displayProduct();
            }
        }
    }

    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(products);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            products = (List<Product>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
