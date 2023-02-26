package project;

import java.util.ArrayList;

public class User {

    private int userId;

    private String login;
    private String password;
    private long wallet;
    private String name;
    private String surname;
    private String passportNumber;

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



    public void addTicket(Ticket ticket){
        ticketWallet.add(ticket);
    }
    public void removeTicket(Ticket ticket){ticketWallet.remove(ticket);}


}

