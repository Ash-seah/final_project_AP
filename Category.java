import java.util.ArrayList;

public class Category {
    String name;
    ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Category> categories = new ArrayList<>();

    public Category(String name) {
        this.name = name;
        Category.categories.add(this);
    }

    // TODO: in case category name is incorrect
    public static Category find_category(String name){
        for (Category category : Category.categories){
            if (category.name.equals(name)){
                return category;
            }
        }
        return null;
    }
}