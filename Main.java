import java.util.*;
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop("ashkanland", "www.ashkan.com", "09101641067");
        Admin admin = new Admin("admin", "admin", "admin@gmail.com");
        Account currAccount = null;
        Scanner scn = new Scanner(System.in);

        //test zone
        Category beauty = new Category("beauty");
        Category clothes = new Category("clothes");
        Category electronics = new Category("electronics");
        Category furniture = new Category("furniture");
        Category books = new Category("books");

//        beauty.products.add(new Product("hair dryer", 46.15, 10, beauty));
//        beauty.products.add(new Product("lipstick", 5.48, 10, beauty));
//        clothes.products.add(new Product("jeans", 3.98, 10, clothes));
//        clothes.products.add(new Product("tshirt", 2.98, 10, clothes));
//        electronics.products.add(new Product("Galaxy A110 super duper", 9000.0, 10, electronics));
//        electronics.products.add(new Product("SAMSUNG TV", 499.99, 10, electronics));
//        furniture.products.add(new Product("SAMSUNG smart couch", 238.90, 10, furniture));
//        furniture.products.add(new Product("intelligent chair", 993.56, 10, furniture));
//        books.products.add(new Product("meditations", 999.99, 10, books));
//        books.products.add(new Product("metamorphosis", 29.99, 10, books));
        //test zone

        // register/login menu
        while (true) {
            while (currAccount == null) {
                System.out.println("1 - Login \n2 - Register");
                int n = scn.nextInt();
                switch (n) {
                    case 1:
                        String usr = scn.next();
                        String pwd = scn.next();
                        currAccount = login(usr, pwd);
                        if (currAccount == null) {
                            System.out.println("dne");
                        }
                        System.out.println(currAccount.username);
                        break;
                    case 2:
                        System.out.println("1 - as buyer \n2 - as seller");
                        int choice = scn.nextInt();
                        if (choice == 1) {

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
                        System.out.println("Registration complete!");
                        break;
                }

            }

            // buyer menu
            while (currAccount instanceof Buyer) {
                // TODO: add comment
                // test zone
                currAccount.shoppingCart.put(books.products.get(0), 2);
                currAccount.shoppingCart.put(beauty.products.get(0), 4);
                currAccount.shoppingCart.put(electronics.products.get(0), 5);
                // test zone

                System.out.println("1 - edit profile \n2 - add funds \n3 - see products \n" +
                        "4 - search for a product \n5 - shopping cart \n6 - logout");
                int choice = scn.nextInt();

                // edit profile
                if (choice == 1) {
                    currAccount.username = scn.next();
                    currAccount.password = scn.next();
                    currAccount.emailAddress = scn.next();
                    currAccount.phoneNumber = scn.next();
                    currAccount.address = scn.next();
                    currAccount.log.add("Buyer" + currAccount.username + "changed their profile details");
                }

                // add fund
                if (choice == 2) {
                    System.out.println("amount:");
                    int amount = scn.nextInt();
                    new Request(((Buyer) currAccount), amount);
                    System.out.println("your funds will be transferred once an admin approves your request.");
                    currAccount.log.add("Buyer" + currAccount.username + "has requested €" + amount);
                }

                // TODO: add to shopping cart
                // see products
                if (choice == 3) {
                    int index = 1;
                    for (Category category : Category.categories) {
                        System.out.println(index + " - " + category.category_name);
                        index += 1;
                    }
                    int subChoice = scn.nextInt();
                    index = 1;
                    for (Product product : Category.categories.get(subChoice - 1).products) {
                        System.out.println(index + " - " + product.name + " ----- " + "€" + product.price);
                        index += 1;
                    }
                    int subsubchoice = scn.nextInt();
                    Category.categories.get(subChoice - 1).products.get(subsubchoice - 1).displayProduct();
                    System.out.println(" ------------------------------- ");
                    Category.categories.get(subChoice - 1).products.get(subsubchoice - 1).display_comments();

                    System.out.println("1 - add to shopping cart \n2 - back");
                    int subsubsubchoice = scn.nextInt();
                    if (subsubsubchoice == 1){
                        ((Buyer) currAccount).addToCart(Category.categories.get(subChoice - 1).products.get(subsubchoice - 1));
                        currAccount.log.add("buyer " + currAccount.username + " has added " + Category.categories.get(subChoice - 1).products.get(subsubchoice - 1).name + " to their shopping cart");
                    }
                    if (subsubsubchoice == 2){
                        //back
                    }
                }

                // search for a product
                if (choice == 4) {
                    System.out.println("enter product category_name:");
                    String name = scn.next();
                    Product searched_for_product = Shop.find_product(name);
                    searched_for_product.displayProduct();
                    searched_for_product.display_comments();
                    System.out.println("1 - Buy \n2 - back");
                    int choicechoice = scn.nextInt();
                    if (choicechoice == 1){
                        ((Buyer) currAccount).addToCart(searched_for_product);
                        currAccount.log.add("buyer " + currAccount.username + " has added " + searched_for_product.name + " to their shopping cart.");
                    }
                    if (choicechoice == 2){
                        // back
                    }
                }

                //TODO: buy
                //TODO: add balance to seller
                // shopping cart
                if (choice == 5) {
                    int index = 1;
                    double totalPrice = 0;
                    for (Product product : currAccount.shoppingCart.keySet()) {
                        System.out.println(index + " - " + product.name + " ------------ " + currAccount.shoppingCart.get(product));
                        totalPrice += currAccount.shoppingCart.get(product) * product.price;
                        index += 1;
                    }
                    System.out.println("total price is: " + totalPrice);
                    System.out.println("1 - Buy \n2 - Back");
                    int choice2 = scn.nextInt();
                    if (choice2 == 1){
                        if (currAccount.balance > totalPrice){
                            ((Buyer) currAccount).orders_list.add(new Order((Buyer) currAccount, totalPrice));
                            currAccount.log.add(currAccount.username + " has bought every item in their shopping cart.");
                        }
                        else {
                            System.out.println("insufficient balance");
                        }
                    }
                    if (choice2 == 2){
                        // back
                    }
                }

                // logout
                if (choice == 6) {
                    System.out.println(currAccount.username + " logged out");
                    currAccount = null;
                }
            }

            // seller menu
            while (currAccount instanceof Seller) {
                // request selling certificate
                new Request((Seller) currAccount);

                System.out.println("1 - edit profile \n2 - available products \n3 - logout");
                int n = scn.nextInt();

                // edit profile
                if (n == 1) {
                    String companyName = scn.next();
                    String password = scn.next();

                    ((Seller) currAccount).username = companyName;
                    ((Seller) currAccount).password = password;

                    currAccount.log.add("Seller " + currAccount.username + " changed their profile details");
                }

                // available products
                if (n == 2 && ((Seller) currAccount).selling_cert) {
                    ((Seller) currAccount).display_available_products();
                    System.out.println("1 - add product \n2 - remove product");
                    int choice = scn.nextInt();

                    // add products
                    if (choice == 1) {
                        System.out.println("category_name: ");
                        String name = scn.next();
                        System.out.println("price: ");
                        double price = scn.nextDouble();
                        System.out.println("stock: ");
                        int stock = scn.nextInt();
                        System.out.println("category: ");
                        String category_str = scn.next();
                        Category category = Category.find_category(category_str);
                        Product newProduct = new Product(name, price, stock, (Seller) currAccount);
                        ((Seller) currAccount).sellerProducts.add(newProduct);
                    }

                    // remove products
                    if (choice == 2) {
                        int index = 1;
                        for (Product product : ((Seller) currAccount).sellerProducts) {
                            System.out.println(index + " - " + product.name + " ----- " + "€" + product.price);
                            index += 1;
                        }
                        int subchoice = scn.nextInt();
                        if (((Seller) currAccount).sellerProducts.get(subchoice - 1).stock > 1) {
                            ((Seller) currAccount).sellerProducts.get(subchoice - 1).stock -= 1;
                        } else {
                            ((Seller) currAccount).sellerProducts.get(subchoice - 1).category.products.remove(((Seller) currAccount).sellerProducts.get(subchoice - 1));
                            ((Seller) currAccount).sellerProducts.remove(subchoice - 1);
                        }
                    }
                }
            }

            while (currAccount instanceof Admin) {
                System.out.println("1 - promote to admin \n2 - add fund \n3 - fund requests \n4 - orders \n5 - certificates \n6 - logout");
                int choice = scn.nextInt();

                // promote to admin
                if (choice == 1) {
                    System.out.println("enter the username of the account of the user that you wish to promote:");
                    String username = scn.next();
                    Account newAdmin = Shop.find_account(username);
                    new Admin(newAdmin.username, newAdmin.password, newAdmin.emailAddress);
                    Shop.customers.remove(newAdmin);
                }

                // TODO: unique usernames
                // add fund
                if (choice == 2) {
                    System.out.println("username:");
                    String username = scn.next();
                    System.out.println("amount to increase:");
                    double amountToIncrease = scn.nextDouble();
                    Shop.find_account(username).balance += amountToIncrease;
                }

                // fund requests
                if (choice == 3) {
                    Request.display_fund_requests();
                    int subChoice = scn.nextInt();
                    ((Admin) currAccount).accept_fund_request(Request.fundRequestsList.get(subChoice - 1));
                    Request.fundRequestsList.remove(subChoice - 1);

                }

                // orders
                if (choice == 4) {
                    Order.display_orders();
                    int subchoice = scn.nextInt();
                    Order chosenOrder = Shop.orders.get(subchoice - 1);
                    ((Admin) currAccount).approve_order(chosenOrder);
                    // removing from both order lists
                    chosenOrder.buyer.orders_list.remove(chosenOrder);
                    Shop.orders.remove(subchoice - 1);

                }

                // certificates
                if (choice == 5) {
                    Request.display_selling_certs();
                    int subChoice = scn.nextInt();
                    ((Admin) currAccount).approve_selling_cert(Request.sellingCertRequestsList.get(subChoice - 1));
                    Request.fundRequestsList.remove(subChoice - 1);
                }

                // logout
                if (choice == 6) {
                    currAccount = null;
                }
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
        Shop.customers.add(new Buyer(username, password, emailAddress, phoneNumber, address));
    }
    public static void register_as_seller(String username, String password) {
        Shop.customers.add(new Seller(username, password));
    }
}