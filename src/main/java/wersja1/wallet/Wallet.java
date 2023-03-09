package wersja1.wallet;

import java.util.Scanner;

public class Wallet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        System.out.println("Saldo początkowe: " + account.getBalance());
        System.out.print("Wprowadź kwotę wpłaty: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        System.out.println("Saldo po wpłacie: " + account.getBalance());
        System.out.print("Wprowadź kwotę zakupów: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);
        System.out.println("Saldo po wypłacie: " + account.getBalance());

    }
}
