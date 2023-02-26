package project;


import project.Flight.AirplaneName;

public class Ticket {
    private int ticketId;
    private String ticketNumber;
    private String passengerName;
    private String passportNumber;
    private long price;
    private String flightNumber;
    private AirplaneName airplaneName;
    private int seatNumber;
    private boolean additionalCargo;
    private boolean premiumSeat;
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

    public Ticket(String ticketNumber, String passengerName, String passportNumber, long price, String flightNumber, AirplaneName airplaneName, int seatNumber, boolean additionalCargo, boolean premiumSeat, boolean priorityCheckIn) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.passportNumber = passportNumber;
        this.price = price;
        this.flightNumber = flightNumber;
        this.airplaneName = airplaneName;
        this.seatNumber = seatNumber;
        this.additionalCargo = additionalCargo;
        this.premiumSeat = premiumSeat;
        this.priorityCheckIn = priorityCheckIn;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public long getPrice() {
        return price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public AirplaneName getAirplaneName() {
        return airplaneName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAdditionalCargo() {
        return additionalCargo;
    }

    public boolean isPremiumSeat() {
        return premiumSeat;
    }

    public boolean isPriorityCheckIn() {
        return priorityCheckIn;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAirplaneName(AirplaneName airplaneName) {
        this.airplaneName = airplaneName;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setAdditionalCargo(boolean additionalCargo) {
        this.additionalCargo = additionalCargo;
    }

    public void setPremiumSeat(boolean premiumSeat) {
        this.premiumSeat = premiumSeat;
    }

    public void setPriorityCheckIn(boolean priorityCheckIn) {
        this.priorityCheckIn = priorityCheckIn;
    }
}



