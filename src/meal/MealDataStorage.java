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
        return meals;
    }
}
