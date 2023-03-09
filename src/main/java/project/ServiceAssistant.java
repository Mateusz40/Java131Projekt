package project;

import java.util.ArrayList;
import java.util.Scanner;
import project.Flight.Flight;

import javax.persistence.Entity;

@Entity
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

    private final UserType userType = UserType.SERVICEASSISTANT;

    @Override
    public UserType getUserType() {
        return userType;
    }
}
