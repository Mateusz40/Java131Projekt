package project.Flight;



public class Flight {

   int dateOfDepartures;
   int dateOfArrivals;
   AirportName airportArrivals;
   AirportName airportDepartures;
   AirplaneName airplane;


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

   public AirplaneName airplane() {
      return airplane;
   }

   public Flight setAirplane(AirplaneName airplane) {
      this.airplane = airplane;
      return this;
   }

   public Flight(int dateOfDepartures, int dateOfArrivals, AirportName airportArrivals, AirportName airportDepartures, AirplaneName airplane) {
      this.dateOfDepartures = dateOfDepartures;
      this.dateOfArrivals = dateOfArrivals;
      this.airportArrivals = airportArrivals;
      this.airportDepartures = airportDepartures;
      this.airplane = airplane;
   }
}
