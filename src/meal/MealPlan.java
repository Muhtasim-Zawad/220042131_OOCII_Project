package meal;

import java.util.List;

public class MealPlan {
    private List<Meal> breakfast;
    private List<Meal> lunch;
    private List<Meal> dinner;

    public MealPlan(List<Meal> breakfast, List<Meal> lunch, List<Meal> dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
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

    public void showMealPlan() {
        System.out.println("\033[1;34m--- Breakfast ---\033[0m");
        breakfast.forEach(meal -> System.out.println(meal.getName() + " - Calories: " + meal.getCalories()));
        System.out.println("\033[1;34m--- Lunch ---\033[0m");
        lunch.forEach(meal -> System.out.println(meal.getName() + " - Calories: " + meal.getCalories()));
        System.out.println("\033[1;34m--- Dinner ---\033[0m");
        dinner.forEach(meal -> System.out.println(meal.getName() + " - Calories: " + meal.getCalories()));
    }
}
