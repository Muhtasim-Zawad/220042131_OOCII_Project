package meal;

import java.io.*;
import java.util.*;

public class MealDataStorage {

    private static final String MEAL_FILE = "resources/meals.csv";

    public static void saveMeal(Meal meal) {
        try (FileWriter writer = new FileWriter(MEAL_FILE, true)) {
            writer.write(meal.getName() + "," + meal.getCalories() + "," + meal.getProtein() + "," + meal.getCarbs() + "," + meal.getFats() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving meal data: " + e.getMessage());
        }
    }

    public static List<Meal> loadMeals() {
        List<Meal> meals = new ArrayList<>();

        // Check if meals file exists or is empty, if so, add predefined meals
        File mealFile = new File(MEAL_FILE);
        if (!mealFile.exists() || mealFile.length() == 0) {
            System.out.println("\033[1;33mNo meals found. Loading default meals...\033[0m");
            meals.addAll(loadDefaultMeals());
            saveDefaultMeals(meals);  // Save predefined meals for future use
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(MEAL_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] mealData = line.split(",");
                    if (mealData.length == 5) {
                        meals.add(new Meal(mealData[0], Integer.parseInt(mealData[1]), Integer.parseInt(mealData[2]), Integer.parseInt(mealData[3]), Integer.parseInt(mealData[4])));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error loading meal data: " + e.getMessage());
            }
        }
        return meals;
    }

    // Save default meals into the CSV file
    public static void saveDefaultMeals(List<Meal> meals) {
        try (FileWriter writer = new FileWriter(MEAL_FILE)) {
            for (Meal meal : meals) {
                writer.write(meal.getName() + "," + meal.getCalories() + "," + meal.getProtein() + "," + meal.getCarbs() + "," + meal.getFats() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving default meals: " + e.getMessage());
        }
    }

    // Load a set of predefined meals
    private static List<Meal> loadDefaultMeals() {
        List<Meal> defaultMeals = new ArrayList<>();
        defaultMeals.add(new Meal("Scrambled Eggs & Toast", 350, 20, 30, 20));
        defaultMeals.add(new Meal("Grilled Chicken Salad", 400, 35, 15, 20));
        defaultMeals.add(new Meal("Steamed Fish with Quinoa", 450, 40, 25, 15));
        defaultMeals.add(new Meal("Greek Yogurt with Berries", 200, 15, 20, 5));
        defaultMeals.add(new Meal("Avocado & Chicken Wrap", 500, 30, 40, 25));
        return defaultMeals;
    }
}
