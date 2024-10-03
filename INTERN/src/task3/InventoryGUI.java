package task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryGUI {
    private InventoryManagement inventory;

    public InventoryGUI() {
        inventory = new InventoryManagement();
        createLoginScreen();
    }

    private void createLoginScreen() {
        JFrame loginFrame = new JFrame("Inventory Management System - Login");
        loginFrame.setSize(400, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        loginFrame.add(panel, null);
        placeLoginComponents(panel);

        loginFrame.setVisible(true);
    }

    private void placeLoginComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50, 30, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 30, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 70, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 70, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 110, 160, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = String.valueOf(passwordText.getPassword());

                if (User.authenticate(username, password)) {
                    createMainScreen();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials, try again.");
                }
            }
        });
    }

    private void createMainScreen() {
        JFrame mainFrame = new JFrame("Inventory Management System");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        mainFrame.add(panel, null);
        placeMainComponents(panel);

        mainFrame.setVisible(true);
    }

    private void placeMainComponents(JPanel panel) {
        panel.setLayout(null);

        JButton addButton = new JButton("Add Product");
        addButton.setBounds(50, 50, 150, 25);
        panel.add(addButton);

        JButton editButton = new JButton("Edit Product");
        editButton.setBounds(50, 100, 150, 25);
        panel.add(editButton);

        JButton deleteButton = new JButton("Delete Product");
        deleteButton.setBounds(50, 150, 150, 25);
        panel.add(deleteButton);

        JButton displayButton = new JButton("Display Products");
        displayButton.setBounds(50, 200, 150, 25);
        panel.add(displayButton);

        JButton lowStockButton = new JButton("Low Stock Report");
        lowStockButton.setBounds(50, 250, 150, 25);
        panel.add(lowStockButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productId = JOptionPane.showInputDialog("Enter Product ID:");
                String productName = JOptionPane.showInputDialog("Enter Product Name:");
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));

                Product product = new Product(productId, productName, price, quantity);
                inventory.addProduct(product);
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productId = JOptionPane.showInputDialog("Enter Product ID to Edit:");
                String productName = JOptionPane.showInputDialog("Enter New Product Name:");
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter New Price:"));
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter New Quantity:"));

                inventory.editProduct(productId, productName, price, quantity);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String productId = JOptionPane.showInputDialog("Enter Product ID to Delete:");
                inventory.deleteProduct(productId);
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inventory.displayAllProducts();
            }
        });

        lowStockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int threshold = Integer.parseInt(JOptionPane.showInputDialog("Enter Low Stock Threshold:"));
                inventory.lowStockReport(threshold);
            }
        });
    }

    public static void main(String[] args) {
        new InventoryGUI();
    }
}


