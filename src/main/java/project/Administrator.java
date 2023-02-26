package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrator extends User {



    private static ServiceAssistant makeNewServiceAssistant(String login, String password, long wallet, String name, String surname, String passportNumber, ArrayList<Ticket> ticketWallet){
        return new ServiceAssistant( login, password,wallet,name, surname, passportNumber, ticketWallet);
    }





    public Administrator(String login, String password, long wallet, String name, String surname, String passportNumber, ArrayList<Ticket> ticketWallet) {
        super(login, password, wallet, name, surname, passportNumber, ticketWallet);
    }


}
