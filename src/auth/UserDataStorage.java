package auth;

import java.io.*;
import java.util.*;

public class UserDataStorage {

    private static final String USER_FILE = "resources/users.csv";

    public static void saveUserData(User user) {
        try (FileWriter writer = new FileWriter(USER_FILE, true)) {
            writer.write(user.toCSV());
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    public static List<User> loadUserData() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 4) {
                    users.add(new User(userData[0], Integer.parseInt(userData[1]), Integer.parseInt(userData[2]), userData[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
        return users;
    }
}
