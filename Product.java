import java.util.*;

public class Product {
    String name;
    double price;
    int stock;
    Category category;
    ArrayList<String> comments;

    public Product(String name, double price, int stock, Category category){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public void displayProperties(Product product){

    }
}
