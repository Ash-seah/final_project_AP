import java.util.*;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("ashkanland", "www.ashkan.com", "09101641067");
        Account currAccount;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Login \n 2 - Register");
            int n = scn.nextInt();
            switch (n){
                case 1:
                    String usr = scn.next();
                    String pwd = scn.next();
                    currAccount = login(usr, pwd);
                    if (currAccount == null){
                        System.out.println("dne");
                    }
                    System.out.println(currAccount.username);
                    break;
                case 2:
                    System.out.println("1 - as buyer \n 2 - as seller");
                    int choice = scn.nextInt();
                    if (choice == 1){
                        String username = scn.next();
                        String password = scn.next();
                        String email = scn.next();
                        String phoneNumber = scn.next();
                        String address = scn.next();

                        register_as_buyer(username, password, email, phoneNumber, address);
                    }
                    if (choice == 2) {
                        String shopname = scn.next();
                        String password = scn.next();

                        register_as_seller(shopname, password);
                    }
                    break;
            }
        }



    }

    public static Account login(String username, String password){
        for (Account account : Shop.customers){
            if (account.username.equals(username) && account.password.equals(password)){
                return account;
            }
        }
        return null;
    }

    public static void register_as_buyer(String username, String password, String emailAddress, String phoneNumber, String address) {
        Shop.customers.add(new Account(username, password, emailAddress, phoneNumber, address, Access.BUYER));
    }
    public static void register_as_seller(String username, String password) {
        Shop.customers.add(new Account(username, password, null, null, null, Access.SELLER));
    }
}