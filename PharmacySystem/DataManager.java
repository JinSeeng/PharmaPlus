package PharmacySystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class DataManager {
    // Load data from the JSON file "stocks_pharma.json"
    public static Pharmacy loadData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Use a relative path to the JSON file
            File file = new File("Resources/json/stocks_pharma.json");
            if (!file.exists()) {
                System.out.println("File not found: " + file.getAbsolutePath());
                return null;
            }
            return mapper.readValue(file, Pharmacy.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Save data to a JSON file
    public static void saveData(Pharmacy pharmacy, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Use a relative path to the JSON file
            File file = new File("Resources/json/" + filename);
            mapper.writeValue(file, pharmacy);
            System.out.println("Data saved successfully to: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}