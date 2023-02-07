public class VendingMachineOutput {
    Product product; // Product from current transaction
    double change;  // Change from current transaction

    // Constructor
    public VendingMachineOutput(Product product, double change) {
        this.product = product;
        this.change = change;
    }
}
