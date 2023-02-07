public class Drink extends Product {

    // Use parent class's constructor
    public Drink(String productName) {
        super(productName);
    }

    // Drink consume method
    @Override
    public void consume() {
        System.out.println("You drank the " + this.productName + ". Yummy!");
    }
}
