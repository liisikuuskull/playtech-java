package test_data.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionReader {

    public static List<Transaction> readTransactionsFromMultipleFiles(String... filePaths) {
        List<Transaction> transactions = new ArrayList<>();

        for (String filePath : filePaths) {
            List<Transaction> transactionsFromFile = readTransactions(filePath);
            transactions.addAll(transactionsFromFile);
        }

        return transactions;
    }

    static List<Transaction> readTransactions(String filePath) {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Loeme faili rida haaval
            while ((line = br.readLine()) != null) {
                // Jätkame ainult, kui rida pole tühi
                if (!line.trim().isEmpty()) {
                    // Jaga rida koma järgi
                    String[] parts = line.split(",");
                    // Kontrolli, kas rida on täielik
                    if (parts.length == 6) {
                        // Loe väärtused
                        int transactionId = Integer.parseInt(parts[0]);
                        int userId = Integer.parseInt(parts[1]);
                        String type = parts[2];
                        double amount = Double.parseDouble(parts[3]);
                        String method = parts[4];
                        String accountNumber = parts[5];
                        // Lisa uus Transaction objekt listi
                        transactions.add(new Transaction(transactionId, userId, type, amount, method, accountNumber));
                    } else {
                        // Kui rida pole täielik, prindi veateade
                        System.err.println("Vigane rida: " + line);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return transactions;
    }


public static List<Bins> readBins(String filePath) {
    List<Bins> binsList = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        // Loeme faili rida haaval
        while ((line = br.readLine()) != null) {
            // Jätkame ainult, kui rida pole tühi
            if (!line.trim().isEmpty()) {
                // Jaga rida koma järgi
                String[] parts = line.split(",");
                // Kontrolli, kas rida on täielik
                if (parts.length == 5) {
                    // Loe väärtused
                    String name = parts[0];
                    long rangeFrom = Long.parseLong(parts[1]);
                    long rangeTo = Long.parseLong(parts[2]);
                    String type = parts[3];
                    String country = parts[4];
                    // Lisa uus Bins objekt listi
                    Bins bin = new Bins();
                    bin.setName(name);
                    bin.setRangeFrom(rangeFrom);
                    bin.setRangeTo(rangeTo);
                    bin.setType(type);
                    bin.setCountry(country);
                    binsList.add(bin);
                } else {
                    // Kui rida pole täielik, prindi veateade
                    System.err.println("Vigane rida: " + line);
                }
            }
        }
    } catch (IOException | NumberFormatException e) {
        e.printStackTrace();
    }

    return binsList;
}

public static List<Bins> readBinsFromMultipleFiles(String string, String string2, String string3) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'readBinsFromMultipleFiles'");
}

}
