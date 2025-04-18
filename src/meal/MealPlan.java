package meal;

import java.util.*;

public class MealPlan {

    private List<Meal> breakfast;
    private List<Meal> lunch;
    private List<Meal> dinner;

    public MealPlan() {
        breakfast = new ArrayList<>();
        lunch = new ArrayList<>();
        dinner = new ArrayList<>();
    }

    public void addBreakfast(Meal meal) {
        breakfast.add(meal);
    }

    public void addLunch(Meal meal) {
        lunch.add(meal);
    }

    public void addDinner(Meal meal) {
        dinner.add(meal);
    }

    public List<Meal> getBreakfast() {
        return breakfast;
    }

    public List<Meal> getLunch() {
        return lunch;
    }

    public List<Meal> getDinner() {
        return dinner;
    }

    public void clear() {
        breakfast.clear();
        lunch.clear();
        dinner.clear();
    }

    // Show the meal plan for the week (7 days)
    public void showMealPlan() {
        System.out.println("\033[1;34m--- Meal Plan ---\033[0m");
        System.out.println("\033[1;33m--- Breakfast ---\033[0m");
        for (Meal meal : breakfast) {
            System.out.println(meal.getName() + " - Calories: " + meal.getCalories() + ", Protein: " + meal.getProtein() + "g, Carbs: " + meal.getCarbs() + "g, Fats: " + meal.getFats() + "g");
        }
        System.out.println("\033[1;33m--- Lunch ---\033[0m");
        for (Meal meal : lunch) {
            System.out.println(meal.getName() + " - Calories: " + meal.getCalories() + ", Protein: " + meal.getProtein() + "g, Carbs: " + meal.getCarbs() + "g, Fats: " + meal.getFats() + "g");
        }
        System.out.println("\033[1;33m--- Dinner ---\033[0m");
        for (Meal meal : dinner) {
            System.out.println(meal.getName() + " - Calories: " + meal.getCalories() + ", Protein: " + meal.getProtein() + "g, Carbs: " + meal.getCarbs() + "g, Fats: " + meal.getFats() + "g");
        }
    }
}
