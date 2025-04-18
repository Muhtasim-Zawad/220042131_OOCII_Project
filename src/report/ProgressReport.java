package report;

public class ProgressReport {
    private int totalCaloriesConsumed;
    private double totalGroceryExpense;

    public ProgressReport(int totalCaloriesConsumed, double totalGroceryExpense) {
        this.totalCaloriesConsumed = totalCaloriesConsumed;
        this.totalGroceryExpense = totalGroceryExpense;
    }

    public void showReport() {
        System.out.println("\033[1;35m--- Weekly Progress Report ---\033[0m");
        System.out.println("Total Calories Consumed: " + totalCaloriesConsumed);
        System.out.println("Total Grocery Expense: $" + totalGroceryExpense);
    }

    public int getTotalCaloriesConsumed() {
        return totalCaloriesConsumed;
    }

    public double getTotalGroceryExpense() {
        return totalGroceryExpense;
    }
}
