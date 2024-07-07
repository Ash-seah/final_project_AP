import java.util.*;

public class Account {
    String username;
    String password;
    String emailAddress;
    String phoneNumber;
    String address;

    // TODO: remove something from shoppingcart
    HashMap<Product, Integer> shoppingCart = new HashMap<>();
    ArrayList<String> log = new ArrayList<>();

    double balance = 0.0;

    public Account(String username, String password, String emailAddress, String phoneNumber, String address, Access access) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

}

class Admin extends Account {
    public void accept_fund_request(Request request){
        request.requester.balance += request.amount;
    }
    public void approve_selling_cert(Request request){
        request.seller.selling_cert = true;
    }

    public boolean approve_order(Order order){
        for (Product product : order.buyer.shoppingCart.keySet()){
            if (product.stock >= order.buyer.shoppingCart.get(product)){
                product.stock -= order.buyer.shoppingCart.get(product);
            }
            else {
                System.out.println("insufficient stock");
                return false;
            }
        }
        order.buyer.balance -= order.totalprice;
        for (Product product : order.buyer.shoppingCart.keySet()){
            product.seller.balance += order.buyer.shoppingCart.get(product) * product.price * 0.9;
            Shop.totalProfit += order.buyer.shoppingCart.get(product) * product.price * 0.1;
        }
        order.buyer.bought_list.putAll(order.buyer.shoppingCart);
        order.buyer.shoppingCart.clear();
        return true;
    }

    public Admin(String username, String password, String emailAddress) {
        super(username, password, emailAddress, null, null, Access.ADMIN);
        Shop.customers.add(this);
    }

    static void addAdmin(Account newAdmin){
        // TODO: fix permission escalation
//        Shop.customers.put(newAdmin.username, new Admin(newAdmin.username, newAdmin.password, newAdmin.emailAddress, newAdmin.phoneNumber, newAdmin.address));
    }
}

class Buyer extends Account {

    public Buyer(String username, String password, String emailAddress, String phoneNumber, String address) {
        super(username, password, emailAddress, phoneNumber, address, Access.BUYER);
    }

    HashMap<Product, Integer> bought_list = new HashMap<Product, Integer>();
    ArrayList<Order> orders_list = new ArrayList<>();

    public void addToCart(Product product){
        if (this.shoppingCart.containsKey(product)){
            this.shoppingCart.put(product, this.shoppingCart.get(product) + 1);
        }
        else {
            this.shoppingCart.put(product, 1);
        }
    }


//    public void buyCart(HashMap cart){
//        if (product.stock >= amount && this.balance >= product.price){
//            product.stock -= amount;
//            this.balance -= product.price;
//            System.out.println("purchase successful");
//        }
//        else {
//            if (product.stock < amount){
//                System.out.println("insufficient stock");
//            }
//            if (this.balance < product.price){
//                System.out.println("insufficient balance");
//            }
//        }
//    }
}

class Seller extends Account {
    boolean selling_cert = false;
    ArrayList<Product> sellerProducts = new ArrayList<>();

    public Seller(String username, String password) {
        super(username, password, null, null, null, Access.SELLER);
    }
    public void remove_product(Product product){
        this.sellerProducts.remove(product);
    }

    public void add_product(Product product){
        this.sellerProducts.add(product);
    }

    public void display_available_products(){
        int index = 1;
        for (Product product : this.sellerProducts){
            System.out.println(index + " - " + product.name + " ----- " + product.price);
            index += 1;
        }
    }
}