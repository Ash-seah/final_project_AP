import java.util.*;

public class shop {

    HashMap<String, String> user_pass = new HashMap<>();

    private String name;
    private String webAddress;
    // use String for number because of potential problems with an int number
    private String supportNumber;

    ArrayList<Account> customers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();

    static int totalProfit;

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