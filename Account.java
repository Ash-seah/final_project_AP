import java.util.*;

public class Account {
    String username;
    String password;
    String emailAddress;
    String phoneNumber;
    String address;

    ArrayList<Product> shoppingCart = new ArrayList<>();
    ArrayList<Order> ordersList = new ArrayList<>();
    ArrayList<Product> purchasedProducts = new ArrayList<>();

    int wallet = 0;

    public Account(String username, String password, String emailAddress, String phoneNumber, String address) {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

}

class Admin extends Account {
    static HashMap<String, Admin> user_admin = new HashMap<>();

    public Admin(String username, String password, String emailAddress, String phoneNumber, String address) {
        super(username, password, emailAddress, phoneNumber, address);
        user_admin.put(username, this);
    }

    static void addAdmin(Account newAdmin){
        user_admin.put(newAdmin.username, new Admin(newAdmin.username, newAdmin.password, newAdmin.emailAddress, newAdmin.phoneNumber, newAdmin.address));
    }
}

class Buyer extends Account {
    HashMap<String, Buyer> user_buyer = new HashMap<>();

    public Buyer(String username, String password, String emailAddress, String phoneNumber, String address) {
        super(username, password, emailAddress, phoneNumber, address);
    }
}

class Seller extends Account {
    HashMap<String, Seller> user_seller = new HashMap<>();

    public Seller(String username, String password, String emailAddress, String phoneNumber, String address) {
        super(username, password, emailAddress, phoneNumber, address);
    }
}