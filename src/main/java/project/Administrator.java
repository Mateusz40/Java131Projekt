package project;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;

@Entity
public class Administrator extends User{
    @Column
    @Enumerated(EnumType.STRING)
    private final UserType userType = UserType.ADMINISTRATOR;
    public Administrator() {
    }
    @Override
    public UserType getUserType() {
        return userType;
    }

    @Override
    public int getUserId() {
        return super.getUserId();
    }

    @Override
    public ArrayList<Ticket> getTicketWallet() {
        return (ArrayList<Ticket>) super.getTicketWallet();
    }

    @Override
    public long getWallet() {
        return super.getWallet();
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPassportNumber() {
        return super.getPassportNumber();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void addTicket(Ticket ticket) {
        super.addTicket(ticket);
    }

    @Override
    public void removeTicket(Ticket ticket) {
        super.removeTicket(ticket);
    }

    public UserType userType() {
        return userType;
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPassportNumber(String passportNumber) {
        super.setPassportNumber(passportNumber);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public void setWallet(long wallet) {
        super.setWallet(wallet);
    }


  //  @Override
  //  public org.hibernate.usertype.UserType getUserType() {
  //      return userType;
  //  }

}
