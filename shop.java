import java.util.*;

public class Shop {

//    static HashMap<String, String> user_pass = new HashMap<>();
//    static HashMap<String, Account> user_acc = new HashMap<>();

    private String name;
    private String webAddress;
    // use String for number because of potential problems with an int number
    private String supportNumber;

    static ArrayList<Account> customers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Request> orders = new ArrayList<>();

    static int totalProfit;

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