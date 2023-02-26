package project.Flight;

import javax.persistence.*;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;
    @Column(name="airplane_id")
    private int airplaneId;

    @Column(name = "airplane_model")
    @Enumerated(EnumType.STRING)
    private AirplaneName airplaneName;
    @Column(name="number_of_seats")
    private final int numberOfSeats;

    public int getAirplaneId() {
        return airplaneId;
    }

    public AirplaneName getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(AirplaneName airplaneName) {
        this.airplaneName = airplaneName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Airplane(AirplaneName airplaneName, int numberOfSeats) {
        this.airplaneName = airplaneName;
        this.numberOfSeats = numberOfSeats;
    }
}
