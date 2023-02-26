package project.Flight;



public class Flight {
   int flightId;
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

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("project.Flight.Flight{");
      sb.append("dateOfDepartures=").append(dateOfDepartures);
      sb.append(", dateOfArrivals=").append(dateOfArrivals);
      sb.append(", airportArrivals=").append(airportArrivals);
      sb.append(", airportDepartures=").append(airportDepartures);
      sb.append(", airplane=").append(airplane);
      sb.append('}');
      return sb.toString();
   }
}
