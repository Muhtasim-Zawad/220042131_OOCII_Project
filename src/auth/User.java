package auth;

public class User {
    private String name;
    private int currentCalories;
    private int targetCalories;
    private String goal;

    public User(String name, int currentCalories, int targetCalories, String goal) {
        this.name = name;
        this.currentCalories = currentCalories;
        this.targetCalories = targetCalories;
        this.goal = goal;
    }

    public String toCSV() {
        return name + "," + currentCalories + "," + targetCalories + "," + goal + "\n";
    }

    public String getName() {
        return name;
    }

    public int getCurrentCalories() {
        return currentCalories;
    }

    public int getTargetCalories() {
        return targetCalories;
    }

    public String getGoal() {
        return goal;
    }
}
