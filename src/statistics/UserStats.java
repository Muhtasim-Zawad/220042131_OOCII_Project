package statistics;

public class UserStats {
    private String userName;
    private int dailyCalories;
    private boolean mealPlanFollowed;

    public UserStats(String userName, int dailyCalories, boolean mealPlanFollowed) {
        this.userName = userName;
        this.dailyCalories = dailyCalories;
        this.mealPlanFollowed = mealPlanFollowed;
    }

    public String getUserName() {
        return userName;
    }

    public int getDailyCalories() {
        return dailyCalories;
    }

    public boolean isMealPlanFollowed() {
        return mealPlanFollowed;
    }
}
