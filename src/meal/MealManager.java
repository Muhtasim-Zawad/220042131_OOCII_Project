package meal;

import java.util.*;

public class MealManager {

    private List<Meal> availableMeals;  // List of all available meals
    private MealPlan mealPlan;  // Meal plan for breakfast, lunch, and dinner

    public MealManager() {
        availableMeals = new ArrayList<>();
        mealPlan = new MealPlan();
        loadPredefinedMeals();  // Load available meals from predefined list or CSV
    }

    // Load predefined meals from MealDataStorage
    private void loadPredefinedMeals() {
        MealDataStorage.loadDefaultMeals();
        List<Meal> predefinedMeals = MealDataStorage.loadMeals();;
        availableMeals.addAll(predefinedMeals);  // Add the predefined meals to the meal list
    }

    // Add a meal to the meal plan (breakfast, lunch, or dinner)
    public void addMeal(Meal meal, String mealType) {
        if ("breakfast".equalsIgnoreCase(mealType)) {
            mealPlan.addBreakfast(meal);
        } else if ("lunch".equalsIgnoreCase(mealType)) {
            mealPlan.addLunch(meal);
        } else if ("dinner".equalsIgnoreCase(mealType)) {
            mealPlan.addDinner(meal);
        }
    }

    // Remove a meal from the meal plan
    public void removeMeal(String mealName) {
        // Remove meal from both available meals and meal plan (breakfast, lunch, dinner)
        removeMealFromCategory(availableMeals, mealName);
        removeMealFromCategory(mealPlan.getBreakfast(), mealName);
        removeMealFromCategory(mealPlan.getLunch(), mealName);
        removeMealFromCategory(mealPlan.getDinner(), mealName);
    }

    private void removeMealFromCategory(List<Meal> meals, String mealName) {
        meals.removeIf(meal -> meal.getName().equalsIgnoreCase(mealName));
    }

    // Show the meal plan (breakfast, lunch, dinner)
    public void showMealPlan() {
        mealPlan.showMealPlan();
    }

    // Show all available meals (not just the meal plan)
    public void showAllMeals() {
        System.out.println("\033[1;32m--- All Available Meals ---\033[0m");
        for (Meal meal : availableMeals) {
            System.out.println(meal.getName() + " - Calories: " + meal.getCalories() + ", Protein: " + meal.getProtein() + "g, Carbs: " + meal.getCarbs() + "g, Fats: " + meal.getFats() + "g");
        }
    }

    // Set the meal plan based on the user's goal and calorie intake
    public void setMealPlan(String goal, int targetCalories) {
        mealPlan.clear();  // Clear existing meal plan

        int totalCalories = 0;
        List<Meal> breakfastMeals = new ArrayList<>();
        List<Meal> lunchMeals = new ArrayList<>();
        List<Meal> dinnerMeals = new ArrayList<>();

        // Add available meals to different lists based on meal type
        for (Meal meal : availableMeals) {
            if (meal.getMealType().equals("breakfast")) {
                breakfastMeals.add(meal);
            } else if (meal.getMealType().equals("lunch")) {
                lunchMeals.add(meal);
            } else if (meal.getMealType().equals("dinner")) {
                dinnerMeals.add(meal);
            }
        }

        // Select meals for the plan
        System.out.println("breakfast meals count : " + breakfastMeals.size());
        Meal selectedBreakfast = selectMeal(breakfastMeals);
        Meal selectedLunch = selectMeal(lunchMeals);
        Meal selectedDinner = selectMeal(dinnerMeals);

        // Add the meals to the plan
        mealPlan.addBreakfast(selectedBreakfast);
        mealPlan.addLunch(selectedLunch);
        mealPlan.addDinner(selectedDinner);

        // Calculate the total calories for all three meals
        totalCalories = selectedBreakfast.getCalories() + selectedLunch.getCalories() + selectedDinner.getCalories();

        // Adjust meals based on weight goal
        if ("Weight Loss".equalsIgnoreCase(goal) && totalCalories > targetCalories) {
            System.out.println("\033[1;33mTotal calories exceeded target for weight loss. Adjusting meal plan.\033[0m");
            while (totalCalories > targetCalories) {
                selectedDinner = selectMeal(dinnerMeals);  // Change dinner to reduce calories
                mealPlan.addDinner(selectedDinner);  // Replace the old dinner with a new one
                totalCalories = selectedBreakfast.getCalories() + selectedLunch.getCalories() + selectedDinner.getCalories();
            }
        } else if ("Weight Gain".equalsIgnoreCase(goal) && totalCalories < targetCalories) {
            System.out.println("\033[1;33mTotal calories too low for weight gain. Adjusting meal plan.\033[0m");
            while (totalCalories < targetCalories) {
                selectedDinner = selectMeal(dinnerMeals);  // Change dinner to increase calories
                mealPlan.addDinner(selectedDinner);  // Replace the old dinner with a new one
                totalCalories = selectedBreakfast.getCalories() + selectedLunch.getCalories() + selectedDinner.getCalories();
            }
        }

        System.out.println("\033[1;32mMeal plan has been set for your goal: " + goal + "\033[0m");
    }

    // Select a meal based on available meals
    private Meal selectMeal(List<Meal> availableMeals) {
        if (availableMeals.isEmpty()) {
            throw new IllegalArgumentException("No available meals to select from.");
        }
        // Select a random meal from the available meals list for simplicity
        Random rand = new Random();
        return availableMeals.get(rand.nextInt(availableMeals.size()));
    }

    // Get all meals from meal plan (breakfast, lunch, dinner)
    public List<Meal> getMealList() {
        List<Meal> allMeals = new ArrayList<>();
        allMeals.addAll(mealPlan.getBreakfast());
        allMeals.addAll(mealPlan.getLunch());
        allMeals.addAll(mealPlan.getDinner());
        return allMeals;
    }

    public void clearMeals() {
        availableMeals.clear();
    }
}
