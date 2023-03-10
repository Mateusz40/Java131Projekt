package project;


import project.Flight.AdditionalCargo;
import project.Flight.Flight;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;
    @ManyToOne
    @JoinColumn(name = "tickets_id")
    private User user;
    @Column(name="ticket_price")
    private long price;
    @Column(name="flight_number")
    private int flightNumber;
    @OneToMany(mappedBy = "ticket")
    private List<Flight> flight;
    @Column(name="additional_cargo")
    @Enumerated(EnumType.STRING)
    private AdditionalCargo additionalCargo;
    @Column(name="premium")
    private boolean premium;
    @Column(name="priority_check_in")
    private boolean priorityCheckIn;


    public Ticket() {
    }

    public Ticket(User user, int flightNumber, List<Flight> flight, AdditionalCargo additionalCargo, boolean premium, boolean priorityCheckIn) {
        this.user = user;
        this.flightNumber = flightNumber;
        this.flight = flight;
        this.additionalCargo = additionalCargo;
        this.premium = premium;
        this.priorityCheckIn = priorityCheckIn;
    }

    public Ticket buyTicket(User user) {
        Ticket ticket = new Ticket();
        price = 250;
        switch (additionalCargo){
            case SMALL -> price += 100;
            case MEDIUM -> price += 150;
            case LARGE -> price += 250;
            default -> {
            }
        }
        if (premium){
            price += 150;
        }
        if (priorityCheckIn){
            price += 75;
        }
        if (user.getWallet() >= ticket.price) {
            user.setWallet(user.getWallet() - ticket.price);
            user.addTicket(ticket);
        }else{
            System.out.println("Brak środków");
        }
        return ticket;
    }

    public void returnTicket(User user, Ticket ticket){

        user.removeTicket(ticket);
        user.setWallet(user.getWallet() + ticket.price);


        }

    public Ticket(User user,long price, int flightNumber, AdditionalCargo additionalCargo, boolean premiumSeat, boolean priorityCheckIn) {
        this.user = user;
        this.price = price;
        this.flightNumber = flightNumber;
        this.additionalCargo = additionalCargo;
        this.premium = premiumSeat;
        this.priorityCheckIn = priorityCheckIn;
    }

    public int getId() {
        return Id;
    }

    public long getPrice() {return price;}

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



