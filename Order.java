import java.util.ArrayList;

public class Order {
    double totalprice;
    Buyer buyer;
    static ArrayList<Order> orders = new ArrayList<>();

    public Order(Buyer buyer, double totalprice){
        this.buyer = buyer;
        this.totalprice = totalprice;
        orders.add(this);
    }

    public static void display_orders(){
        int index = 1;
        for (Order order : Order.orders){
            System.out.println(index + " - " + order.buyer.username + " ---------------- " + "€" + order.totalprice);
            index += 1;
        }
    }
}
