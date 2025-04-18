package statistics;

public class StatsManager {
    private int caloriesConsumed;
    private boolean mealPlanFollowed;

    public StatsManager() {
        caloriesConsumed = 0;
        mealPlanFollowed = false;
    }

    public void trackDayStats(int calories, boolean followed) {
        caloriesConsumed += calories;
        mealPlanFollowed = followed;
    }

    public void showStats() {
        System.out.println("\033[1;33m--- Daily Stats ---\033[0m");
        System.out.println("Calories Consumed Today: " + caloriesConsumed);
        System.out.println("Meal Plan Followed: " + (mealPlanFollowed ? "Yes" : "No"));
    }
}
