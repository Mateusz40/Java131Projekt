package project;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Scanner;

@Entity
public class User {

    public boolean loggedIn = false;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int userId;

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String passportNumber;
    private long wallet;
    private final ArrayList<Ticket> ticketWallet;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public ArrayList<Ticket> getTicketWallet() {
        return ticketWallet;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public long getWallet() {
        return wallet;
    }

    public void setWallet(long wallet) {
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public User(String login, String password, long wallet, String name, String surname, String passportNumber, ArrayList<Ticket> ticketWallet) {
        this.login = login;
        this.password = password;
        this.wallet = wallet;
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.ticketWallet = ticketWallet;
    }


    public void loggingIn(User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Select 1 of the following actions \n Log in \n Sign up");
        String chosenOption = s.nextLine();
        if (chosenOption.equals("Log in")) {

            System.out.println("Please insert your login");
            String loginInput = s.nextLine();
            System.out.println("Please insert your password");
            String passwordInput = s.nextLine();
            if (loginInput.equals(login) && (passwordInput.equals(password))) {
                user.setLoggedIn(true);
            } else {
                System.out.println("Incorrect password or login");
            }
        } else if (chosenOption.equals("Sign up")) {

        }else {
            System.out.println("Incorrect action");
        }
    }





    public void addTicket(Ticket ticket){
        ticketWallet.add(ticket);
    }
    public void removeTicket(Ticket ticket){ticketWallet.remove(ticket);}


}

