package Labs.Seventh;

import java.util.ArrayList;
import java.util.List;

public class Aircraft {
    private String model;
    private int numPass;
    private final List<Passenger> passengerList = new ArrayList<>();

    public Aircraft(String model, int numPass) {
        this.model = model;
        this.numPass = numPass;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumPass() {
        return numPass;
    }

    public void setNumPass(int numPass) {
        this.numPass = numPass;
    }

    public String fly(){
        return "The " + model + " takes off";
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    @Override
    public String toString() {
        return "Aircraft " +
                "model='" + model + '\'';
    }
}