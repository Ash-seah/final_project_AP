import java.util.*;

public class Product extends Category {
    String information;
    Seller seller;
    String name;
    double price;
    int stock;
    ArrayList<String> comments;

    public Product(String name, double price, int stock, Seller seller, String information, Category category){
        super(category.category_name);
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.seller = seller;
        this.information = information;
        Shop.products.add(this);
        category.products.add(this);
    }

    public void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + "€" + price);
        System.out.println("Quantity: " + stock);
        System.out.println("Category: " + category.category_name);
        System.out.println("Additional information " + information);
        System.out.println("Comments: " + comments);
    }
    public void display_comments() {
        for (String string : this.comments){
            System.out.println(string);
        }
    }

    public void add_comment(String string){
        this.comments.add(string);
    }
}
