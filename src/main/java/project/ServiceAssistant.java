package project;

import java.util.ArrayList;
import java.util.Scanner;
import project.Flight.Flight;

public class ServiceAssistant extends User{

//    public void delayFlight(Flight flight){
//        if(loggedIn){
//            Scanner s = new Scanner(System.in);
//            int newDate = s.nextInt();
//            flight.setDateOfDepartures(newDate);
//
//        }else {
//            System.out.println("You must be logged in on your Service Assistant account in order to perform this action");
//        }
//    }


    public ServiceAssistant(String login, String password, long wallet, String name, String surname, String passportNumber, ArrayList<Ticket> ticketWallet) {
        super(login, password, wallet, name, surname, passportNumber, ticketWallet);
    }

    public ServiceAssistant() {
    }

}
