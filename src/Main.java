import auth.AuthManager;
import meal.Meal;
import meal.MealManager;
import grocery.GroceryManager;
import report.ReportManager;
import statistics.StatsManager;
import file.FileManager;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\033[1;34m\n===========================================");
        System.out.println("        Welcome to HealthFit Planner!      ");
        System.out.println("===========================================");
        System.out.println("\033[0m");

        AuthManager authManager = new AuthManager();
        MealManager mealManager = new MealManager();
        GroceryManager groceryManager = new GroceryManager();
        ReportManager reportManager = new ReportManager();
        StatsManager statsManager = new StatsManager();

        // User authentication
        System.out.println("Please choose an option:");
        System.out.println("1. New User");
        System.out.println("2. Existing User");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();  // Consume the newline

        if (choice == 1) {
            authManager.registerNewUser(sc);
        } else if (choice == 2) {
            authManager.loginUser(sc);
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        // After authentication, give the user interactive options
        while (true) {
            System.out.println("\n\033[1;33m--- Main Menu ---\033[0m");
            System.out.println("1. View Meal Plan");
            System.out.println("2. Manage Meals (Add/Remove)");
            System.out.println("3. View and Generate Grocery List");
            System.out.println("4. Generate Weekly Progress Report");
            System.out.println("5. Track Meal Plan Adherence");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();  // Consume the newline

            switch (option) {
                case 1:
                    viewMealPlan(mealManager, sc);
                    break;

                case 2:
                    manageMeals(mealManager, sc);
                    break;

                case 3:
                    generateGroceryList(mealManager, groceryManager, sc);
                    break;

                case 4:
                    generateProgressReport(reportManager, sc);
                    break;

                case 5:
                    trackMealPlanAdherence(statsManager, sc);
                    break;

                case 6:
                    System.out.println("\033[1;31mExiting program. Goodbye!\033[0m");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\033[1;31mInvalid choice. Please try again.\033[0m");
                    break;
            }
        }
    }

    private static void viewMealPlan(MealManager mealManager, Scanner sc) {
        System.out.println("\033[1;34m--- Meal Plan ---\033[0m");
        mealManager.showMealPlan();
    }

    private static void manageMeals(MealManager mealManager, Scanner sc) {
        System.out.println("\033[1;32m--- Manage Meals ---\033[0m");
        System.out.println("1. Add Meal");
        System.out.println("2. Remove Meal");
        System.out.print("Choose an option: ");
        int manageOption = sc.nextInt();
        sc.nextLine();  // Consume the newline

        if (manageOption == 1) {
            System.out.print("Enter meal name: ");
            String name = sc.nextLine();
            System.out.print("Enter calories: ");
            int calories = sc.nextInt();
            System.out.print("Enter protein: ");
            int protein = sc.nextInt();
            System.out.print("Enter carbs: ");
            int carbs = sc.nextInt();
            System.out.print("Enter fats: ");
            int fats = sc.nextInt();
            sc.nextLine();  // Consume the newline

            Meal meal = new Meal(name, calories, protein, carbs, fats);
            mealManager.addMeal(meal);
            System.out.println("\033[1;32mMeal added successfully!\033[0m");

        } else if (manageOption == 2) {
            System.out.print("Enter meal name to remove: ");
            String mealName = sc.nextLine();
            mealManager.removeMeal(mealName);
            System.out.println("\033[1;31mMeal removed successfully!\033[0m");

        } else {
            System.out.println("\033[1;31mInvalid option.\033[0m");
        }
    }

    private static void generateGroceryList(MealManager mealManager, GroceryManager groceryManager, Scanner sc) {
        System.out.println("\033[1;32m--- Generating Grocery List ---\033[0m");
        groceryManager.generateGroceryList(mealManager.getMealList());
        groceryManager.displayGroceryList();
        System.out.println("\033[1;34mTotal cost of grocery list: $" + groceryManager.calculateTotalCost() + "\033[0m");
    }

    private static void generateProgressReport(ReportManager reportManager, Scanner sc) {
        System.out.println("\033[1;35m--- Generating Weekly Progress Report ---\033[0m");
        System.out.print("Enter total calories consumed this week: ");
        int calories = sc.nextInt();
        System.out.print("Enter total grocery expense this week: ");
        double expense = sc.nextDouble();

        reportManager.addProgress(calories, expense);
        reportManager.generateReport();
    }

    private static void trackMealPlanAdherence(StatsManager statsManager, Scanner sc) {
        System.out.println("\033[1;33m--- Track Meal Plan Adherence ---\033[0m");
        System.out.print("Enter calories consumed today: ");
        int calories = sc.nextInt();
        System.out.print("Did you follow the meal plan today? (yes/no): ");
        String followed = sc.next();

        boolean mealPlanFollowed = followed.equalsIgnoreCase("yes");
        statsManager.trackDayStats(calories, mealPlanFollowed);
        statsManager.showStats();
    }
}
