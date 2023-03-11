package project.Flight;


import project.Ticket;

import javax.persistence.*;

@Entity
public class Flight {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="flight_id")
   int flightId;
   @Column(name="date_of_departure")
   String dateOfDepartures;
   @Column(name="date_of_arrival")
   String dateOfArrivals;
   @Column(name="arriving_airport")
   @Enumerated(EnumType.STRING)
   AirportName airportArrivals;
   @Column(name="departing_airport")
   @Enumerated(EnumType.STRING)
   AirportName airportDepartures;
   @ManyToOne
   @JoinColumn(name = "airplane_id")
   private Airplane airplane;
   @ManyToOne
   @JoinColumn(name = "ticket")
   private Ticket ticket;

   public Flight() {
   }

   public Airplane getAirplane() {
      return airplane;
   }

   public void setAirplane(Airplane airplane) {
      this.airplane = airplane;
   }

   public Ticket getTicket() {
      return ticket;
   }

   public void setTicket(Ticket ticket) {
      this.ticket = ticket;
   }

   public int getFlightId() {
      return flightId;
   }

   public String getDateOfDepartures() {
      return dateOfDepartures;
   }

   public String getDateOfArrivals() {
      return dateOfArrivals;
   }

   public AirportName getAirportArrivals() {
      return airportArrivals;
   }

   public AirportName getAirportDepartures() {
      return airportDepartures;
   }

   public String dateOfDepartures() {
      return dateOfDepartures;
   }

   public Flight setDateOfDepartures(String dateOfDepartures) {
      this.dateOfDepartures = dateOfDepartures;
      return this;
   }

   public String dateOfArrivals() {
      return dateOfArrivals;
   }

   public void setDateOfArrivals(String dateOfArrivals) {
      this.dateOfArrivals = dateOfArrivals;
   }

   public AirportName airportArrivals() {
      return airportArrivals;
   }

   public void setAirportArrivals(AirportName airportArrivals) {
      this.airportArrivals = airportArrivals;
   }

   public void setAirportDepartures(AirportName airportDepartures) {
      this.airportDepartures = airportDepartures;
   }

   public AirportName airportDepartures() {
      return airportDepartures;
   }



   public Flight(String dateOfDepartures, String dateOfArrivals, AirportName airportArrivals, AirportName airportDepartures) {
      this.dateOfDepartures = dateOfDepartures;
      this.dateOfArrivals = dateOfArrivals;
      this.airportArrivals = airportArrivals;
      this.airportDepartures = airportDepartures;
   }
}
