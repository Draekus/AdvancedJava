import java.util.*;
public class Slot {
    Stack<Product> productList; // List of products
    double price; // Price of item

    // Constructor
    public Slot(Stack<Product> productList, double price) {
        this.productList = productList;
        this.price = price;
    }
}
