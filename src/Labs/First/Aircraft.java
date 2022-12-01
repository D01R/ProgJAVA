package Labs.First;

import java.util.ArrayList;

public class Aircraft {
    private String model;
    public String getModel() {return model;}
    public void setModel(String newName) {model = newName;}

    private int numPass;
    public int getNumPass() {return numPass;}
    public void setPassang(int newNumPass) {numPass = newNumPass;}
    public Aircraft(String name, int numPass){
        this.model =name;
        this.numPass = numPass;
    }


    public void fly(){

        System.out.println("Взлёт");
    }
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    public ArrayList<Passenger> getPassengers() {return passengers;}
    public void addPassenger(Passenger passenger) {
        try
        {
            if (passenger.getPlace() > this.getNumPass())
                throw new KolichestvoException("Невозможно добавить пассажира " + passenger.getName() + " в аппарат " + this.getModel());
            else
                passengers.add(passenger);
        }
        catch (KolichestvoException kolichestvoException){
            System.out.println(kolichestvoException.getMessage());
        }
    }
    public void removePassenger(Passenger passenger) {passengers.remove(passenger);}
}
