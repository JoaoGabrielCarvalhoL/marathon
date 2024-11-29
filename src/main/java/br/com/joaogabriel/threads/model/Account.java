package br.com.joaogabriel.threads.model;

public class Account {
    private int balance = 50;

    public void withdrawal(int amount) {
        if (amount > this.balance) {
            System.out.println("insufficient balance.");
        } else {
            this.balance = this.balance - amount;
            System.out.println("Success! Actual balance: " + this.balance);
        }
    }

    public int getBalance() {
        return this.balance;
    }
}
