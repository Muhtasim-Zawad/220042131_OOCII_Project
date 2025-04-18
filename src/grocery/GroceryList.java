package grocery;

import meal.Meal;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {
    private List<GroceryItem> items;

    public GroceryList() {
        items = new ArrayList<>();
    }

    public void generateList(List<Meal> meals) {
        // Example logic to generate a grocery list for each meal
        for (Meal meal : meals) {
            items.add(new GroceryItem(meal.getName(), meal.getCalories() * 0.1)); // Simplified cost formula
        }
    }

    public void showGroceryList() {
        System.out.println("\033[1;32m--- Grocery List ---\033[0m");
        items.forEach(item -> System.out.println(item.getName() + " - Price: $" + item.getPrice()));
    }
}
