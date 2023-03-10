package project;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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



}
