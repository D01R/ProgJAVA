package Labs.Sixth;

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

    public void setNumPass(int newNumPass) {
        numPass = newNumPass;
    }

    public Aircraft() {
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

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

}
