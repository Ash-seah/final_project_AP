import java.util.ArrayList;

public class Order {
    double totalprice;
    Buyer buyer;

    public Order(Buyer buyer, double totalprice){
        this.buyer = buyer;
        this.totalprice = totalprice;
        Shop.orders.add(this);
    }

    public static void display_orders(){
        int index = 1;
        for (Order order : Shop.orders){
            System.out.println(index + " - " + order.buyer.username + " ---------------- " + "€" + order.totalprice);
            index += 1;
        }
    }
}
