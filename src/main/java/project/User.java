package project;


import project.Flight.AdditionalCargo;
import project.Flight.AirplaneName;
import project.Flight.AirportName;
import project.Flight.Flight;

import javax.persistence.*;
import java.time.Month;
import java.time.MonthDay;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Entity
public class User {

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
    @Transient
    private long wallet;
    @OneToMany(mappedBy = "user")
    private List<Ticket> ticketWallet;
    @Column
    private final UserType userType = UserType.STANDARD;

    public User(String login, String password, long wallet, String name, String surname, String passportNumber, List<Ticket> ticketWallet) {
        this.login = login;
        this.password = password;
        this.wallet = wallet;
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.ticketWallet = ticketWallet;
    }

    public User() {
    }

    public UserType getUserType() {
        return userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public List<Ticket> getTicketWallet() {
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

    public void addTicket(Ticket ticket) {
        ticketWallet.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        ticketWallet.remove(ticket);
    }
    public void addToWallet(long credit){
        wallet += credit;
    }



    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", wallet=" + wallet +
                ", ticketWallet=" + ticketWallet +
                '}';
    }
}


