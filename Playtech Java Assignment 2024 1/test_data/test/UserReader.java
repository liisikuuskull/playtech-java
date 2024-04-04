package test_data.test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class UserReader {

    public static List<User> readUsers(String filePath) {
        List<User> users = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] fields = line.split(",");
                String userId = fields[0];
                String username = fields[1];
                double balance = Double.parseDouble(fields[2]);
                String country = fields[3];
                int frozen = Integer.parseInt(fields[4]);
                double depositMin = Double.parseDouble(fields[5]);
                double depositMax = Double.parseDouble(fields[6]);
                double withdrawMin = Double.parseDouble(fields[7]);
                double withdrawMax = Double.parseDouble(fields[8]);

                User user = new User(userId, username, balance, country, frozen, depositMin, depositMax, withdrawMin, withdrawMax);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
/* 
    public static List<User> parseUsers(List<String> lines) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseUsers'");
    }
    */

    public static List<User> parseUsers(List<String> lines) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseUsers'");
    }
}