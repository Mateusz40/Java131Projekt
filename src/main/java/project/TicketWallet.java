package project;

import java.util.ArrayList;
import java.util.List;

public class TicketWallet {
    List<Ticket> ticketWallet = new ArrayList<>()

    public addTicket(Ticket ticket){
        ticketWallet.add(ticket);
    }

    public removeTicket(ticket){
        ticketWallet.remove(ticket);
    }
}
