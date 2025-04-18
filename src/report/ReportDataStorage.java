package report;

import java.io.*;
import java.util.*;

public class ReportDataStorage {

    private static final String REPORT_FILE = "resources/reports.csv";

    public static void saveReport(ProgressReport report) {
        try (FileWriter writer = new FileWriter(REPORT_FILE, true)) {
            writer.write("Calories Consumed: " + report.getTotalCaloriesConsumed() + ", ");
            writer.write("Grocery Expense: " + report.getTotalGroceryExpense() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving report data: " + e.getMessage());
        }
    }

    public static List<ProgressReport> loadReports() {
        List<ProgressReport> reports = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(REPORT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] reportData = line.split(",");
                int calories = Integer.parseInt(reportData[0].split(":")[1].trim());
                double expense = Double.parseDouble(reportData[1].split(":")[1].trim());
                reports.add(new ProgressReport(calories, expense));
            }
        } catch (IOException e) {
            System.out.println("Error loading report data: " + e.getMessage());
        }
        return reports;
    }
}
