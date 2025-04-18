package meal;

public class Meal {

    private String name;
    private int calories;
    private int protein;
    private int carbs;
    private int fats;
    private String mealType;  // New field to specify the meal type (breakfast, lunch, dinner)

    public Meal(String name, int calories, int protein, int carbs, int fats, String mealType) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.mealType = mealType;  // Set the meal type
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFats() {
        return fats;
    }

    public String getMealType() {
        return mealType;  // Return the meal type
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;  // Set the meal type
    }

    // Convert the meal to CSV format for saving to the file
    public String toCSV() {
        return name + "," + calories + "," + protein + "," + carbs + "," + fats + "," + mealType + "\n";
    }
}
