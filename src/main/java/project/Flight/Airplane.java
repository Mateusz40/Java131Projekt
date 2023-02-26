package project.Flight;

import javax.persistence.*;
import java.util.List;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="airplane_id")
    private int airplaneId;

    public List<Integer> getFlightNumbers() {
        return flightNumbers;
    }

    @Column(name = "airplane_model")
    @Enumerated(EnumType.STRING)
    private AirplaneName airplaneName;
    @Column(name="number_of_seats")
    private final int numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "flight_number")
    private List<Integer> flightNumbers;

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
