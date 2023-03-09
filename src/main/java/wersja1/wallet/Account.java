package wersja1.wallet;

public class Account {
    private double balance;

    public Account(){
        this.balance = 0;
    }
    public void deposit(double value){
        this.balance += value;
    }
    public void withdraw(double value){
        if (value <= this.balance){
            this.balance -= value;
        } else {
            System.out.println("Nie masz wystarczających środków na bilet");
        }
    }

    public double getBalance() {
        return balance;
    }
}
