package Labs.Second;

import java.util.ArrayList;

public class Aircraft {
    private String model;
    public String getModel() {return model;}
    public void setModel(String newName) {model = newName;}

    private int numPass;
    public int getNumPass() {return numPass;}
    public void setPassang(int newNumPass) {numPass = newNumPass;}
    public Aircraft(){
        System.out.print("¬ведите название: ");
        this.model = Input.inputLine();
//        this.model = ScannerInput.inputLine();
        System.out.print("¬ведите максимальное количество пассажиров: ");
        this.numPass = Input.inputNumber();
//        this.numPass = ScannerInput.inputNumber();
    }


    public void fly(){

        System.out.println("¬злЄт");
    }
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    public ArrayList<Passenger> getPassengers() {return passengers;}
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
    public void removePassenger(Passenger passenger) {passengers.remove(passenger);}
}
