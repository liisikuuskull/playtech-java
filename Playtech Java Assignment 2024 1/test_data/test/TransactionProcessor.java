package test_data.test;

import java.util.List;
import test_data.test.Transaction;
import test_data.test.User;


public class TransactionProcessor {
    public static void processTransactions(List<Transaction> transactions, List<User> users) {
        for (Transaction transaction : transactions) {
            // Rakendage erinevaid kontrollimeetmeid iga tehingu jaoks
    
            // Näiteks, kui tehing on kehtiv, värskendage kasutaja saldot
            if (isTransactionValid(transaction, users)) {
                updateUserBalance(transaction, users);
            } else {
                // Kui tehing ei ole kehtiv, looge sündmusekirje
                generateEvent(transaction, "DECLINED", "Transaction is not valid");
            }
        }
    }

    private static void generateEvent(Transaction transaction, String status, String message) {
        // Implementeerige sündmuse kirje loomise loogika
        // Sündmuse kirje salvestamine või väljastamine vastavalt ülesande nõuetele
        // Näiteks: System.out.println(transaction.getId() + "," + status + "," + message);
    }

    private static boolean isTransactionValid(Transaction transaction, List<User> users) {
        // Leia vastav kasutaja tehingu kasutaja ID järgi
        User user = getUserById(transaction.getUserId(), users);
        
        if (user == null || user.isFrozen()) {
            // Kasutajat ei leitud või kasutaja konto on külmutatud
            return false;
        }

        // Implementeerige tehingute valideerimise loogika vastavalt ülesande nõuetele
        // Näiteks:
        // - Kontrollige tehingu tüüpi (DEPOSIT või WITHDRAW)
        // - Kontrollige tehingu summat
        // - Rakendage muud vajalikud kontrollid

        return true; // Tehing on kehtiv
    }

    private static User getUserById(int id, List<User> users) {
        // Leia kasutaja ID järgi kasutajate listist
        for (User user : users) {
            if (user.getUserId().equals(String.valueOf(id))) {  // Võrdleb String tüüpi väärtusega, mis onkonverteeritud int- tüüpi
                return user;
            }
        }
        return null; // Kasutajat ei leitud
    }

    private static void updateUserBalance(Transaction transaction, List<User> users) {
        // Leia vastav kasutaja tehingu kasutaja ID järgi
        User user = getUserById(transaction.getUserId(), users);
        
        // Värskenda kasutaja saldo vastavalt tehingule
        if (transaction.getType().equals("DEPOSIT")) {
            user.setBalance(user.getBalance() + transaction.getAmount());
        } else if (transaction.getType().equals("WITHDRAW")) {
            user.setBalance(user.getBalance() - transaction.getAmount());
        }
    }
}    