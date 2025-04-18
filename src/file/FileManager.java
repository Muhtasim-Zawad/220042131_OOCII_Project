package file;

import meal.Meal;
import auth.User;
import java.io.*;
import java.util.*;

public class FileManager {

    private static final String USER_FILE = "resources/users.csv";
    private static final String MEAL_FILE = "resources/meals.csv";

    public static void saveUserData(User user) {
        try (FileWriter writer = new FileWriter(USER_FILE, true)) {
            writer.write(user.toCSV());
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    public static void saveMeals(List<Meal> meals) {
        try (FileWriter writer = new FileWriter(MEAL_FILE)) {
            for (Meal meal : meals) {
                writer.write(meal.getName() + "," + meal.getCalories() + "," + meal.getProtein() + "," + meal.getCarbs() + "," + meal.getFats() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving meal data: " + e.getMessage());
        }
    }

    public static List<String> readFile(String filename) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return data;
    }
}
