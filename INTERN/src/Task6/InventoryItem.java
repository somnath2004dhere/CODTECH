package Task6;

import java.io.Serializable;

public class InventoryItem implements Serializable {
    private String itemName;
    private int quantity;
    private String supplier;

    public InventoryItem(String itemName, int quantity, String supplier) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void displayItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Supplier: " + supplier);
    }
}

