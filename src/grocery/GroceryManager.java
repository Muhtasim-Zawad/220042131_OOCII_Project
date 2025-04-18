package grocery;

import meal.Meal;

import java.util.*;

public class GroceryManager {

    private List<GroceryItem> groceryItems;

    public GroceryManager() {
        groceryItems = new ArrayList<>();
    }

    public void generateGroceryList(List<Meal> meals) {
        groceryItems.clear();
        for (Meal meal : meals) {
            groceryItems.add(new GroceryItem(meal.getName(), meal.getCalories() * 0.1)); // Simple cost calculation, can be enhanced
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (GroceryItem item : groceryItems) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    public void displayGroceryList() {
        System.out.println("\033[1;32m--- Grocery List ---\033[0m");
        for (GroceryItem item : groceryItems) {
            System.out.println(item.getName() + " - Price: $" + item.getPrice());
        }
    }
}
