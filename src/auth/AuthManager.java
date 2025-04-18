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

        sc.nextLine();  

        System.out.print("Enter health and fitness goal (Weight Loss, Weight Gain): ");
        String goal = sc.nextLine();

        User newUser = new User(name, currentCalories, targetCalories, goal);

        
        UserDataStorage.saveUserData(newUser);

        
        MealManager mealManager = new MealManager();
        mealManager.setMealPlan(goal, targetCalories);

        
        System.out.println("\033[1;32mRegistration successful! You can now log in.\033[0m");
    }

    public void loginUser(Scanner sc) {
        System.out.println("\033[1;32m\n=== User Login ===\033[0m");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        
        try {
            List<User> users = UserDataStorage.loadUserData();
            for (User user : users) {
                if (user.getName().equals(name)) {
                    System.out.println("Welcome back, " + name);
                    showUserDetails(user);

                    
                    MealManager mealManager = new MealManager();
                    mealManager.setMealPlan(user.getGoal(), user.getTargetCalories());
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
        
    }
}
