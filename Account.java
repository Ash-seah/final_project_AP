import java.util.*;

public class Account {
    String username;
    String password;
    String emailAddress;
    String phoneNumber;
    String address;

    // TODO: remove something from shoppingcart
    HashMap<Product, Integer> shoppingCart = new HashMap<>();
    ArrayList<Order> ordersList = new ArrayList<>();
    ArrayList<Product> purchasedProducts = new ArrayList<>();

    int wallet = 0;

    public Account(String username, String password, String emailAddress, String phoneNumber, String address, Access access) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

}

//class Admin extends Account {
//
//    public Admin(String username, String password, String emailAddress, String phoneNumber, String address, Access access) {
//        super(username, password, emailAddress, phoneNumber, address, access.ADMIN);
//        Shop.customers.add(this);
//    }
//
//    static void addAdmin(Account newAdmin){
//        // TODO: fix permission escalation
////        Shop.customers.put(newAdmin.username, new Admin(newAdmin.username, newAdmin.password, newAdmin.emailAddress, newAdmin.phoneNumber, newAdmin.address));
//    }
//}

//class Buyer extends Account {
//
//    public Buyer(String username, String password, String emailAddress, String phoneNumber, String address, Access access) {
//        super(username, password, emailAddress, phoneNumber, address, access.BUYER);
//    }
//
//    public void addToCart(Product product){
//        if (this.shoppingCart.containsKey(product)){
//            this.shoppingCart.put(product, this.shoppingCart.get(product) + 1);
//        }
//        else {
//            this.shoppingCart.put(product, 1);
//        }
//    }

//    public void buyCart(HashMap cart){
//        if (product.stock >= amount && this.wallet >= product.price){
//            product.stock -= amount;
//            this.wallet -= product.price;
//            System.out.println("purchase successful");
//        }
//        else {
//            if (product.stock < amount){
//                System.out.println("insufficient stock");
//            }
//            if (this.wallet < product.price){
//                System.out.println("insufficient balance");
//            }
//        }
//    }
//}

//class Seller extends Account {
//    HashMap<String, Seller> user_seller = new HashMap<>();
//
//    public Seller(String username, String password) {
//        super(username, password, null, null, null);
//    }
//}