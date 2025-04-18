package file;

import java.io.*;
import java.util.*;

public class FileManager {
    public static List<String> readFile(String filename) {
        List<String> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return data;
    }

    public static void writeToFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
        }
    }
}
