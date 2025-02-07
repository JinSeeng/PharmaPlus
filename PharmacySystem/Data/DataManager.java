package PharmacySystem.Data;

import com.fasterxml.jackson.databind.ObjectMapper;
import PharmacySystem.Inventory.Pharmacy;

import java.io.File;
import java.io.IOException;

public class DataManager {
    // Save data to a JSON file
    public static void saveData(Pharmacy pharmacy, String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(filename), pharmacy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load data from a JSON file
    public static Pharmacy loadData(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filename), Pharmacy.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}