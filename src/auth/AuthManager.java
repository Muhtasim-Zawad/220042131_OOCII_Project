package auth;

import java.util.Scanner;
import java.io.*;

public class AuthManager {

    public void registerNewUser(Scanner sc) {
        System.out.println("\033[1;32m\n=== New User Registration ===\033[0m");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter current calorie intake: ");
        int currentCalories = sc.nextInt();

        System.out.print("Enter target calorie intake: ");
        int targetCalories = sc.nextInt();

        sc.nextLine();  // Consume the newline

        System.out.print("Enter health and fitness goal (Weight Loss, Weight Gain): ");
        String goal = sc.nextLine();

        User newUser = new User(name, currentCalories, targetCalories, goal);

        // Store user info in CSV
        try {
            FileWriter writer = new FileWriter("resources/users.csv", true);
            writer.write(newUser.toCSV());
            writer.close();
            System.out.println("\033[1;32mRegistration successful! You can now log in.\033[0m");
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    public void loginUser(Scanner sc) {
        System.out.println("\033[1;32m\n=== User Login ===\033[0m");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Find user from CSV
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resources/users.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(name)) {
                    System.out.println("Welcome back, " + name);
                    showUserDetails(userData);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading user data.");
        }
    }

    private void showUserDetails(String[] userData) {
        System.out.println("\nCurrent Calorie Intake: " + userData[1]);
        System.out.println("Target Calorie Intake: " + userData[2]);
        System.out.println("Goal: " + userData[3]);
        // Further functionality can be added here, like modifying goals
    }
}
