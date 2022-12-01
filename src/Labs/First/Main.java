package Labs.First;

import java.nio.file.Files;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws PolosaRazgonaException {
        Plane plane1 = new Plane("samolet", 1, 4);
        Passenger ilya = new Passenger("Ilya", 1);
        Passenger dair = new Passenger("Dair", 2);
        plane1.addPassenger(ilya);
        plane1.addPassenger(dair);

    }
}

