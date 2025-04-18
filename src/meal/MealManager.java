package meal;

import java.util.*;

public class MealManager {

    private List<Meal> mealList;

    public MealManager() {
        mealList = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        mealList.add(meal);
    }

    public void removeMeal(String mealName) {
        mealList.removeIf(meal -> meal.getName().equalsIgnoreCase(mealName));
    }

    public void showMealPlan() {
        System.out.println("\033[1;34m--- Meal Plan ---\033[0m");
        for (Meal meal : mealList) {
            System.out.println(meal.getName() + " - Calories: " + meal.getCalories() + ", Protein: " + meal.getProtein() + "g, Carbs: " + meal.getCarbs() + "g, Fats: " + meal.getFats() + "g");
        }
    }

    public void showAllMeals() {
        System.out.println("\033[1;32m--- All Available Meals ---\033[0m");
        for (Meal meal : mealList) {
            System.out.println(meal.getName() + " - Calories: " + meal.getCalories() + ", Protein: " + meal.getProtein() + "g, Carbs: " + meal.getCarbs() + "g, Fats: " + meal.getFats() + "g");
        }
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void clearMeals() {
        mealList.clear();
    }
}
