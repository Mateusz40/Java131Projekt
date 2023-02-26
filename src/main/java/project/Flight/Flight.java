package project.Flight;


import javax.persistence.*;

@Entity
public class Flight {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="flight_id")
   int flightId;
   @Column(name="date_of_departure")
   int dateOfDepartures;
   @Column(name="date_of_arrival")
   int dateOfArrivals;
   @Column(name="arriving_airport")
   @Enumerated(EnumType.STRING)
   AirportName airportArrivals;
   @Column(name="departing_airport")
   @Enumerated(EnumType.STRING)
   AirportName airportDepartures;

   //@OneToOne
  // @JoinColumn(name="airplane_id")
   private int airplaneId;

   public int getAirplaneId() {
      return airplaneId;
   }

   public int dateOfDepartures() {
      return dateOfDepartures;
   }

   public Flight setDateOfDepartures(int dateOfDepartures) {
      this.dateOfDepartures = dateOfDepartures;
      return this;
   }

   public int dateOfArrivals() {
      return dateOfArrivals;
   }

   public Flight setDateOfArrivals(int dateOfArrivals) {
      this.dateOfArrivals = dateOfArrivals;
      return this;
   }

   public AirportName airportArrivals() {
      return airportArrivals;
   }

   public Flight setAirportArrivals(AirportName airportArrivals) {
      this.airportArrivals = airportArrivals;
      return this;
   }

   public AirportName airportDepartures() {
      return airportDepartures;
   }

   public Flight setAirportDepartures(AirportName airportDepartures) {
      this.airportDepartures = airportDepartures;
      return this;
   }

   public Flight(int dateOfDepartures, int dateOfArrivals, AirportName airportArrivals, AirportName airportDepartures) {
      this.dateOfDepartures = dateOfDepartures;
      this.dateOfArrivals = dateOfArrivals;
      this.airportArrivals = airportArrivals;
      this.airportDepartures = airportDepartures;
   }
}
