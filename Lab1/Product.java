abstract class Product {
    protected String productName; // Name of product

    Product(String productName) {
        this.productName = productName;
    }
    // Abstract consume method
    public abstract void consume();

}
