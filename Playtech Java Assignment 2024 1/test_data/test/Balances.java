package test_data.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Balances {
    private int userId;
    private double balance;

    // Konstruktor
    public Balances(int userId, double balance) {
        this.userId = userId;
        this.balance = balance;
    }

    // Getterid ja setterid
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

