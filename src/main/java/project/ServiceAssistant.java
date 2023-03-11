package project;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class ServiceAssistant extends User {
    @Column
    @Enumerated(EnumType.STRING)
    private final UserType userType = UserType.SERVICEASSISTANT;
    public ServiceAssistant(){
    }
    @Override
    public UserType getUserType() {
        return userType;
    }


}
