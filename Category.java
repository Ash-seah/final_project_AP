import java.util.ArrayList;

public class Category {
    String category_name;
    Category category;
    ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Category> categories = new ArrayList<>();

    public Category(){

    }
    public Category(String name) {
        this.category_name = name;
        this.category = this;
        Category.categories.add(this);
    }

    // TODO: in case category category_name is incorrect
    public static Category find_category(String name){
        for (Category category : Category.categories){
            if (category.category_name.equals(name)){
                return category;
            }
        }
        return null;
    }
}