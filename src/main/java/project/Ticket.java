package project;


import project.Flight.AdditionalCargo;
import project.Flight.Flight;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_id")
    private int ticketId;
    @OneToMany
    @JoinColumn(name = "ticketId")
    private List<User> users;
    @Column(name="ticket_price")
    private long price;
    @Column(name="flight_number")
    private int flightNumber;
    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @Column(name="additional_cargo")
    @Enumerated(EnumType.STRING)
    private AdditionalCargo additionalCargo;
    @Column(name="premium")
    private boolean premium;
    @Column(name="priority_check_in")
    private boolean priorityCheckIn;



    public Ticket() {
    }



    public void buyTicket(User user) {
        Ticket ticket = new Ticket();
        if (user.getWallet() >= ticket.price) {
            user.setWallet(user.getWallet() - ticket.price);
            user.addTicket(ticket);
        }else{
            System.out.println("Brak środków");
        }
    }

    public void returnTicket(User user, Ticket ticket){

        user.removeTicket(ticket);
        user.setWallet(user.getWallet() + ticket.price);


        }

    public Ticket(List<User> users,long price, int flightNumber, AdditionalCargo additionalCargo, boolean premiumSeat, boolean priorityCheckIn) {
        this.users = users;
        this.price = price;
        this.flightNumber = flightNumber;
        this.additionalCargo = additionalCargo;
        this.premium = premiumSeat;
        this.priorityCheckIn = priorityCheckIn;
    }

    public int getTicketId() {
        return ticketId;
    }

    public long getPrice() {
        return price;
    }

    public int getFlightNumber() {
        return flightNumber;
    }
    public AdditionalCargo isAdditionalCargo() {
        return additionalCargo;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isPriorityCheckIn() {
        return priorityCheckIn;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAdditionalCargo(AdditionalCargo additionalCargo) {
        this.additionalCargo = additionalCargo;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void setPriorityCheckIn(boolean priorityCheckIn) {
        this.priorityCheckIn = priorityCheckIn;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}



