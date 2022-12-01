package Labs.Five;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Airport airport = new Airport("Аэропорт Толмачево");
        Plane plane1 = new Plane("Boeing 737", 234, 1000);
        airport.addAirctaft(plane1);
        Passenger passenger1 = new Passenger("Dair", 100);
        Passenger passenger2 = new Passenger("Ilya", 1);
        plane1.addPassenger(passenger1);
        plane1.addPassenger(passenger2);

        Plane plane2 = new Plane("Boeing 747", 350, 1300);
        airport.addAirctaft(plane2);
        Passenger passenger3 = new Passenger("Alex", 10);
        Passenger passenger4 = new Passenger("Anastasia", 2);
        plane2.addPassenger(passenger3);
        plane2.addPassenger(passenger4);
        AirportReport.create_save(airport, airport.getName());
        System.out.println(AirportReport.readReport(airport.getName()));
    }

}
