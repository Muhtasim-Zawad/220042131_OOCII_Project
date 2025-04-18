package file;

import java.util.List;
import java.util.ArrayList;

public class CSVFileHelper {
    public static List<String[]> parseCSV(List<String> data) {
        List<String[]> parsedData = new ArrayList<>();
        for (String line : data) {
            parsedData.add(line.split(","));
        }
        return parsedData;
    }

    public static String formatForCSV(String[] data) {
        return String.join(",", data) + "\n";
    }
}
