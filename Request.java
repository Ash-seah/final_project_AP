import java.util.ArrayList;

public class Request {
    Account requester;
    int amount;
    static ArrayList<Request> requestsList = new ArrayList<>();

    public Request(Account account, int amount) {
        this.amount = amount;
        this.requester = account;
        requestsList.add(this);
    }
}
