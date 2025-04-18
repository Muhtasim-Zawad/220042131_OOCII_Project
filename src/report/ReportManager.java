package report;

public class ReportManager {

    private int totalCaloriesConsumed;
    private double totalGroceryExpense;

    public ReportManager() {
        totalCaloriesConsumed = 0;
        totalGroceryExpense = 0;
    }

    public void addProgress(int calories, double expense) {
        totalCaloriesConsumed += calories;
        totalGroceryExpense += expense;
    }

    public void generateReport() {
        System.out.println("\033[1;35m--- Weekly Progress Report ---\033[0m");
        System.out.println("Total Calories Consumed: " + totalCaloriesConsumed);
        System.out.println("Total Grocery Expense: $" + totalGroceryExpense);
    }
}
