package test_data.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BalancesReader {
    public static List<Balances> readBalances(String filePath) {
        List<Balances> balancesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // Looge ja lisage iga rida jaoks Balances objekt
                Balances balance = new Balances(0, 0);
                // Määra objektile väärtused vastavalt CSV faili veergudele
                // balance.setName(parts[0]);
                // balance.setBalance(Double.parseDouble(parts[1]));
                balancesList.add(balance);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return balancesList;
    }
}

