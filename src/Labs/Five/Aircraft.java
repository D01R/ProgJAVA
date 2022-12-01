package Labs.Five;

import java.io.Serializable;
import java.util.ArrayList;

public class Aircraft implements Serializable {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String newName) {
        model = newName;
    }

    private int numPass;

    public int getNumPass() {
        return numPass;
    }

    public void setPassang(int newNumPass) {
        numPass = newNumPass;
    }

    public Aircraft(String name, int numPass) {
        this.model = name;
        this.numPass = numPass;
    }

    public void fly() {
        System.out.println("Âçë¸ò");
    }

    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

}
