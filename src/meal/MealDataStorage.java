package meal;

import java.io.*;
import java.util.*;

public class MealDataStorage {

    private static final String MEAL_FILE = "resources/meals.csv";

    // Save a meal to the CSV file with the meal type
    public static void saveMeal(Meal meal) {
        try (FileWriter writer = new FileWriter(MEAL_FILE, true)) {
            writer.write(meal.toCSV());  // Write meal data including meal type
        } catch (IOException e) {
            System.out.println("Error saving meal data: " + e.getMessage());
        }
    }

    // Load all meals from the CSV file and return them as a list
    public static List<Meal> loadMeals() {
        List<Meal> meals = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(MEAL_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] mealData = line.split(",");
                if (mealData.length == 6) {  // Meal has 6 fields (name, calories, protein, carbs, fats, mealType)
                    meals.add(new Meal(mealData[0], Integer.parseInt(mealData[1]), Integer.parseInt(mealData[2]),
                            Integer.parseInt(mealData[3]), Integer.parseInt(mealData[4]), mealData[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading meal data: " + e.getMessage());
        }

        return meals;
    }

    // Save default meals into the CSV file
    public static void saveDefaultMeals(List<Meal> meals) {
        try (FileWriter writer = new FileWriter(MEAL_FILE)) {
            for (Meal meal : meals) {
                writer.write(meal.getName() + "," + meal.getCalories() + "," + meal.getProtein() + "," + meal.getCarbs() + "," + meal.getFats() + "," + meal.getMealType() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving default meals: " + e.getMessage());
        }
    }

    // Load a set of predefined meals
    public static List<Meal> loadDefaultMeals() {
        List<Meal> defaultMeals = new ArrayList<>();
        defaultMeals.add(new Meal("Scrambled Eggs & Toast", 600, 20, 30, 20, "breakfast"));
        defaultMeals.add(new Meal("Grilled Chicken Salad", 900, 35, 15, 20, "lunch"));
        defaultMeals.add(new Meal("Steamed Fish with Quinoa", 700, 40, 25, 15, "dinner"));
        defaultMeals.add(new Meal("Greek Yogurt with Berries", 800, 15, 20, 5, "breakfast"));
        defaultMeals.add(new Meal("Avocado & Chicken Wrap", 800, 30, 40, 25, "lunch"));
        defaultMeals.add(new Meal("Chicken Caesar Salad", 950, 40, 10, 35, "lunch"));
        defaultMeals.add(new Meal("Oatmeal with Almond Butter", 800, 12, 40, 20, "breakfast"));
        defaultMeals.add(new Meal("Spaghetti with Meatballs", 700, 40, 60, 25, "dinner"));
        defaultMeals.add(new Meal("Vegetable Stir-Fry with Tofu", 950, 25, 50, 10, "dinner"));
        defaultMeals.add(new Meal("Pancakes with Syrup", 800, 10, 65, 15, "breakfast"));
        defaultMeals.add(new Meal("Salmon with Sweet Potatoes", 850, 45, 50, 20, "dinner"));
        defaultMeals.add(new Meal("Egg White Omelette", 700, 25, 5, 10, "breakfast"));
        defaultMeals.add(new Meal("Grilled Steak with Veggies", 600, 50, 30, 40, "dinner"));
        defaultMeals.add(new Meal("Lentil Soup with Bread", 800, 25, 60, 10, "lunch"));
        defaultMeals.add(new Meal("Chicken Stir-Fry with Rice", 950, 35, 50, 20, "lunch"));
        defaultMeals.add(new Meal("Fruit Salad with Nuts", 850, 5, 40, 15, "breakfast"));
        defaultMeals.add(new Meal("Quinoa with Roasted Vegetables", 850, 20, 60, 10, "dinner"));
        defaultMeals.add(new Meal("Turkey and Avocado Sandwich", 950, 40, 45, 20, "lunch"));
        defaultMeals.add(new Meal("Tofu Scramble with Spinach", 700, 25, 15, 15, "breakfast"));
        defaultMeals.add(new Meal("Pasta Primavera", 800, 20, 75, 25, "dinner"));
        defaultMeals.add(new Meal("Beef and Broccoli Stir-Fry", 950, 40, 50, 25, "dinner"));
        defaultMeals.add(new Meal("Smoothie with Protein", 800, 30, 50, 10, "breakfast"));
        saveDefaultMeals(defaultMeals);
        return defaultMeals;
    }
}
