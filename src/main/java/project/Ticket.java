package project;



public class Ticket {
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
        if (user.getBalance >= ticket.price) {
            user.addTicket(ticket);
            user.removeFromBalance(ticket.price);

        }
    }


    public void returnTicket(Ticket ticket){
            TicketWallet.removeTicket(ticket);
            Wallet.addToBalance(ticket.price);

        }




}



