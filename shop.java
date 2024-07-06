import java.util.*;

public class Shop {

//    static HashMap<String, String> user_pass = new HashMap<>();
//    static HashMap<String, Account> user_acc = new HashMap<>();

    private String name;
    private String webAddress;
    // use String for number because of potential problems with an int number
    private String supportNumber;

    static ArrayList<Account> customers = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();

    static double totalProfit;

    public static Product find_product(String name){
        for (Product product : Shop.products){
            if (product.name.equals(name)){
                return product;
            }
        }
        return null;
    }

    public static Account find_account(String username){
        for (Account account : customers){
            if (username.equals(account.username)){
                return account;
            }
        }
        return null;
    }

    public Shop(String name, String webAddress, String supportNumber) {
        this.name = name;
        this.webAddress = webAddress;
        this.supportNumber = supportNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSupportNumber(String supportNumber) {
        this.supportNumber = supportNumber;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getName() {
        return name;
    }

    public String getSupportNumber() {
        return supportNumber;
    }

    public String getWebAddress() {
        return webAddress;
    }
}