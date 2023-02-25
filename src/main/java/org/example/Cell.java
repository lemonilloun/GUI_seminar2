package org.example;

public class Cell {
    private double balance = 0.0;
    private String currency = "Tenge"; // валюта
    private String owner;

    public Cell(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOwner() {
        return owner;
    }
}
