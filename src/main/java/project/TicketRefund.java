package project;

import javax.persistence.*;
import java.util.ArrayList;
@Entity


public class TicketRefund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int ticketRefundId;
    @Column
    private String message;


    @Column
    public static ArrayList<Ticket> refundedTickets = new ArrayList<Ticket>();

    public static void acceptTicketRefund(int ticketIndex){
        Ticket ticket = refundedTickets.get(ticketIndex);
        refundedTickets.remove(ticket);
        ticket.getUser().setWallet(ticket.getUser().getWallet() + ticket.getPrice());

    }

    public static void denyTicketRefund(int ticketIndex){
        Ticket ticket = refundedTickets.get(ticketIndex);
        ticket.getUser().addTicket(ticket);
        refundedTickets.remove(ticket);
    }





}