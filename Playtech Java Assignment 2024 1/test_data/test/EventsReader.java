package test_data.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EventsReader {
    public static List<Events> readEvents(String filePath) {
        List<Events> eventsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // Looge ja lisage iga rea jaoks Events objekt
                Events event = new Events(parts[0], parts[1], parts[2]);
                eventsList.add(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return eventsList;
    }
}