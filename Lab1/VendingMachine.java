import java.util.*;

public class VendingMachine {
    private HashMap<String, Slot> products; // Hashmap containing product list and prices for each slot
    static protected double totalSales;

    // Constructor
    public VendingMachine() {
        // Initialize hashmap
        this.products = new HashMap<String, Slot>();
    }

    public void stockItems(String location, Stack<Product> productList, double unitPrice) {
        // Add product list and prices to slot
        this.products.put(location, new Slot(productList, unitPrice));
    }

    public void printInventory() {
        // Iterate over inventory of products
        for (String slot : this.products.keySet()) {
            // Print name of current slot
            System.out.println(slot);
            // Extract the product list and prices from current slot
            Slot currentSlot = this.products.get(slot);
            for (Product product : currentSlot.productList) {
                System.out.println("-" + product.productName);
            }
        }
    }

    public double getTotalSales() {
        return totalSales;
    }

    public VendingMachineOutput purchase(String location, double amount) {
        // Ensure slot is valid
        if (!this.products.containsKey(location)) {
            throw new IllegalArgumentException(location);
        }
        else {
            // Extract the product list and prices from selected slot
            Slot currentSlot = this.products.get(location);
            // Ensure transaction is valid
            if (amount < currentSlot.price) {
                throw new IllegalArgumentException(Double.toString(amount));
            }
            // Ensure there are enough products left
            else if (currentSlot.productList.size() < 1) {
                throw new IllegalArgumentException(location);
            }
            else {
                // Extract one product and remove it from list
                Product purchasedProduct = currentSlot.productList.pop();
                // Calculate change owed
                double change = amount - currentSlot.price;
                // Add current sale to total sales
                totalSales += currentSlot.price;

                // Return output object to user
                return new VendingMachineOutput(purchasedProduct, change);
            }
        }

    }
}
