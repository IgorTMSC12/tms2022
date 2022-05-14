package model;

import java.util.ArrayList;
import java.util.List;

public class StorageCategory {
    private static List<Category> categories = new ArrayList<>();

    public static void createCategory() {
        Category mobilPhone = new Category(1, "Mobil Phone", "mobile.jpg");
        Category laptops = new Category(2, "Laptops", "laptop.jpg");
        Category jpsNavigators = new Category(3, "GPS Navigators", "jps_nav.jpg");
        Category fridges = new Category(4, "Fridges", "fridge.jpg");
        Category car = new Category(5, "Cars", "car.jpg");
        Category camera = new Category(6, "Camera", "camera.jpg");

        categories.add(mobilPhone);
        categories.add(laptops);
        categories.add(jpsNavigators);
        categories.add(fridges);
        categories.add(car);
        categories.add(camera);
    }

    public static List<Category> getCategories() {
        if (categories.size() == 0) {
            createCategory();
        }
        return categories;
    }
}
