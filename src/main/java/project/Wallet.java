package project;

public class Wallet {

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Wallet(int balance) {
        this.balance = balance;
    }

    public Wallet() {
    }
    public void addToBalance(int x){
        balance = balance + x;
    }
    public void removeFromBalance(int x){
        balance = balance - x;
    }
}
