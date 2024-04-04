package test_data.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionSummary {

    public static void main(String[] args) {
        // Loeme kõik tehingud kolmest failist
        List<Transaction> allTransactions = readAllTransactions();

        // Valime välja konkreetse kasutaja tehingud (kasutaja ID-ga 3)
        List<Transaction> userTransactions = filterTransactionsByUserId(allTransactions, 3);

        // Näitame kasutaja tehinguid kokkuvõtlikult
        showTransactionSummary(userTransactions);

          // Koostame kõikide kasutajate kontojäägid
          Map<Integer, Double> accountBalances = calculateAccountBalances(allTransactions);

          // Näitame kõikide kasutajate kontojääke
          showAccountBalances(accountBalances);
    }

    private static void showAccountBalances(Map<Integer, Double> accountBalances) {
        System.out.println("Account balances for all users:");
        for (Map.Entry<Integer, Double> entry : accountBalances.entrySet()) {
            System.out.println("User ID: " + entry.getKey() + ", Account balance: " + entry.getValue());
        }
    }

    private static Map<Integer, Double> calculateAccountBalances(List<Transaction> allTransactions) {
        Map<Integer, Double> accountBalances = new HashMap<>();

        // Käime läbi kõik tehingud ja uuendame vastavalt kasutaja kontojääki
        for (Transaction transaction : allTransactions) {
            int userId = transaction.getUserId();
            double amount = transaction.getAmount();
            accountBalances.put(userId, accountBalances.getOrDefault(userId, 0.0) + amount);
        }

        return accountBalances;
    }

    // Loeb kõik tehingud kolmest failist
    public static List<Transaction> readAllTransactions() {
        List<Transaction> allTransactions = new ArrayList<>();

        // Loeme tehingud kõigist kolmest failist ja lisame need kõik ühte listi
        List<Transaction> transactions1 = TransactionReader.readTransactions("transactions1.csv");
        List<Transaction> transactions2 = TransactionReader.readTransactions("transactions2.csv");
        List<Transaction> transactions3 = TransactionReader.readTransactions("transactions3.csv");

        allTransactions.addAll(transactions1);
        allTransactions.addAll(transactions2);
        allTransactions.addAll(transactions3);

        return allTransactions;
    }

    // Filtrid tehingud kasutaja ID järgi
    private static List<Transaction> filterTransactionsByUserId(List<Transaction> transactions, int userId) {
        List<Transaction> userTransactions = new ArrayList<>();

        // Vaatame iga tehingut ja lisame need kasutaja tehingute hulka, kui nad vastavad antud kasutaja ID-le
        for (Transaction transaction : transactions) {
            if (transaction.getUserId() == userId) {
                userTransactions.add(transaction);
            }
        }

        return userTransactions;
    }

    // Näitab tehinguid kokkuvõtlikult
    private static void showTransactionSummary(List<Transaction> transactions) {
        System.out.println("Summary of user transactions:");
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Type: " + transaction.getType());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Method: " + transaction.getMethod());
            System.out.println("Account Number: " + transaction.getAccountNumber());
            System.out.println();
        }
    }
}
