/* 
package test_data.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserReaderTest {
    public static void main(String[] args) {
        // Loeme kasutajad failist 1
        List<User> users1 = readUsersFromFile("users1.csv");
        printUsers(users1);

        // Loeme kasutajad failist 2
        List<User> users2 = readUsersFromFile("users2.csv");
        printUsers(users2);

        // Loeme kasutajad failist 3
        List<User> users3 = readUsersFromFile("users3.csv");
        printUsers(users3);
    }

    private static List<User> readUsersFromFile(String filename) {
        // Loeme kasutajad CSV failist ja tagastame need listina
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            return UserReader.parseUsers(lines);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void printUsers(List<User> users) {
        // Väljastame iga kasutaja andmed
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Balance: " + user.getBalance());
            System.out.println("Country: " + user.getCountry());
            System.out.println("Frozen: " + user.getFrozen());
            System.out.println("Deposit Min: " + user.getDepositMin());
            System.out.println("Deposit Max: " + user.getDepositMax());
            System.out.println("Withdraw Min: " + user.getWithdrawMin());
            System.out.println("Withdraw Max: " + user.getWithdrawMax());
            System.out.println();
        }
    }
}


*/



// Proovin andmeid lugeda ainult ühest failist 

package test_data.test;

import java.util.List;

public class UserReaderTest {

    public static void main(String[] args) {
        testReadUsersFromFile("users1.csv");
    }

    public static void testReadUsersFromFile(String filename) {
        // Loeme kasutajad failist
        List<User> users = UserReader.readUsers(filename);
        
        // Kontrollime, kas kasutajad on õigesti loetud
        if (users != null) {
            System.out.println("Users read from file " + filename + ":");
            printUsers(users);
        } else {
            System.out.println("Failed to read users from file " + filename);
        }
    }

    private static void printUsers(List<User> users) {
        // Väljastame iga kasutaja andmed
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Balance: " + user.getBalance());
            System.out.println("Country: " + user.getCountry());
            System.out.println("Frozen: " + user.getFrozen());
            System.out.println("Deposit Min: " + user.getDepositMin());
            System.out.println("Deposit Max: " + user.getDepositMax());
            System.out.println("Withdraw Min: " + user.getWithdrawMin());
            System.out.println("Withdraw Max: " + user.getWithdrawMax());
            System.out.println();
        }
    }
}



/* 

package test_data.test;

import java.util.ArrayList;
import java.util.List;

public class UserReaderTest {

    public static void main(String[] args) {
        testReadUsersFromInlineData();
    }

    public static void testReadUsersFromInlineData() {
        // Loome andmed otse testiklassi
        List<String> lines = new ArrayList<>();
        lines.add("1,user1,1000.00,US,0,10.00,500.00,20.00,400.00");
        lines.add("2,user2,2500.00,GB,0,50.00,1000.00,30.00,800.00");
        lines.add("3,user3,500.00,DE,0,20.00,300.00,10.00,200.00");
        lines.add("4,user4,700.00,CA,0,30.00,400.00,15.00,300.00");
        lines.add("5,user5,1500.00,FR,0,40.00,600.00,25.00,500.00");
        lines.add("6,user6,200.00,JP,0,5.00,100.00,5.00,380.00");
        lines.add("7,user7,3000.00,JP,0,100.00,1500.00,50.00,1200.00");

        // Loeme kasutajad otse testiklassi lisatud andmetest
        List<User> users = UserReader.parseUsers(lines);

        // Väljastame iga kasutaja andmed
        printUsers(users);
    }

    private static void printUsers(List<User> users) {
        // Väljastame iga kasutaja andmed
        if (users != null && !users.isEmpty()) {
            for (User user : users) {
                System.out.println("User ID: " + user.getUserId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Balance: " + user.getBalance());
                System.out.println("Country: " + user.getCountry());
                System.out.println("Frozen: " + user.getFrozen());
                System.out.println("Deposit Min: " + user.getDepositMin());
                System.out.println("Deposit Max: " + user.getDepositMax());
                System.out.println("Withdraw Min: " + user.getWithdrawMin());
                System.out.println("Withdraw Max: " + user.getWithdrawMax());
                System.out.println();
            }
        } else {
            System.out.println("No users found.");
        }
    }
}

*/