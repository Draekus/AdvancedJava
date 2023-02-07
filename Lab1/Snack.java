public class Snack extends Product {

    // Use parent class's constructor
    public Snack(String productName) {
        super(productName);
    }

    // Snack consume method
    @Override
    public void consume() {
        System.out.println("You ate the " + this.productName + ". Yummy!");
    }
}
