package PharmacySystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class DataManager {
    // Load data from a JSON file
    public static Pharmacy loadData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Use the relative path to the JSON file
            return mapper.readValue(new File(filePath), Pharmacy.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Save data to a JSON file
    public static void saveData(Pharmacy pharmacy, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filePath), pharmacy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}