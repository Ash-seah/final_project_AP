import java.util.ArrayList;

public class Request {
    Seller seller;
    Buyer requester;
    double amount;
    static ArrayList<Request> fundRequestsList = new ArrayList<>();
    static ArrayList<Request> sellingCertRequestsList = new ArrayList<>();

    public Request(Buyer buyer, double amount) {
        this.amount = amount;
        this.requester = buyer;
        fundRequestsList.add(this);
    }
    public Request(Seller seller){
        this.seller = seller;
        sellingCertRequestsList.add(this);
    }

    public static void display_selling_certs(){
        int index = 1;
        for (Request request : Request.sellingCertRequestsList){
            System.out.println(index + " - " + request.seller.username);
            index += 1;
        }
    }

    public static void display_fund_requests(){
        int index = 1;
        for (Request request : Request.fundRequestsList){
            System.out.println(index + " - " + request.requester.username + " --- " + "€" + request.amount);
            index += 1;
        }
    }
}
