package project;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Entity
public class Administrator extends User{
    private final UserType userType = UserType.ADMINISTRATOR;

    @Override
    public UserType getUserType() {
        return userType;
    }

    public Administrator() {
    }

    public Administrator(String login, String password, long wallet, String name, String surname, String passportNumber, List<Ticket> ticketWallet) {
        super(login, password, wallet, name, surname, passportNumber, ticketWallet);
    }

    //    public static ServiceAssistant makeNewServiceAssistant(String login, String password, long wallet, String name, String surname, String passportNumber, ArrayList<Ticket> ticketWallet){
//        return new ServiceAssistant( login, password,wallet,name, surname, passportNumber, ticketWallet);
//    }


//    public Administrator(String login, String password, long wallet, String name, String surname, String passportNumber, ArrayList<Ticket> ticketWallet) {
//        super(login, password, wallet, name, surname, passportNumber, ticketWallet);
//    }


}
