package auth;

import meal.Meal;
import meal.MealManager;
import meal.MealDataStorage;
import java.util.List;
import java.util.Scanner;

public class AuthManager {

    public void registerNewUser(Scanner sc) {
        System.out.println("\033[1;32m\n=== New User Registration ===\033[0m");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter current calorie intake: ");
        int currentCalories = sc.nextInt();

        System.out.print("Enter target calorie intake: ");
        int targetCalories = sc.nextInt();

        sc.nextLine();  // Consume the newline

        System.out.print("Enter health and fitness goal (Weight Loss, Weight Gain): ");
        String goal = sc.nextLine();

        User newUser = new User(name, currentCalories, targetCalories, goal);

        // Store user info in CSV
        UserDataStorage.saveUserData(newUser);

        // Load predefined meals or set a goal-based meal plan
        MealManager mealManager = new MealManager();
        setMealPlanForUser(mealManager, goal);

        // Display confirmation
        System.out.println("\033[1;32mRegistration successful! You can now log in.\033[0m");
    }

    // Assign a default meal plan based on the user's goal
    private void setMealPlanForUser(MealManager mealManager, String goal) {
        List<Meal> predefinedMeals = MealDataStorage.loadMeals();

        // Clear existing meals to set the new meal plan
        mealManager.clearMeals();

        if ("Weight Loss".equalsIgnoreCase(goal)) {
            // Assign weight loss meal plan
            for (Meal meal : predefinedMeals) {
                if (meal.getCalories() <= 400) {
                    mealManager.addMeal(meal);
                }
            }
        } else if ("Weight Gain".equalsIgnoreCase(goal)) {
            // Assign weight gain meal plan
            for (Meal meal : predefinedMeals) {
                if (meal.getCalories() > 400) {
                    mealManager.addMeal(meal);
                }
            }
        } else {
            // Default meal plan if no goal matches
            mealManager.addMeal(predefinedMeals.get(0)); // Just add one default meal if goal is unclear
        }

        System.out.println("\033[1;32mMeal plan has been set for your goal: " + goal + "\033[0m");
    }

    public void loginUser(Scanner sc) {
        System.out.println("\033[1;32m\n=== User Login ===\033[0m");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Find user from CSV
        try {
            List<User> users = UserDataStorage.loadUserData();
            for (User user : users) {
                if (user.getName().equals(name)) {
                    System.out.println("Welcome back, " + name);
                    showUserDetails(user);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading user data.");
        }
    }

    private void showUserDetails(User user) {
        System.out.println("\nCurrent Calorie Intake: " + user.getCurrentCalories());
        System.out.println("Target Calorie Intake: " + user.getTargetCalories());
        System.out.println("Goal: " + user.getGoal());
        // Further functionality can be added here, like modifying goals
    }
}
