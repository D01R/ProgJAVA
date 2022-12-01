package Labs.Sixth;

import java.io.Serializable;
import java.util.ArrayList;
public class Airport implements Serializable {
    public Airport(){}
    public Airport(String name){
        this.name = name;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
    private ArrayList<Aircraft> aircrafts = new ArrayList<Aircraft>();
    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }
    public void setAircrafts(ArrayList<Aircraft> aircrafts) { this.aircrafts = aircrafts;}
    public void addAirctaft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }
    public void removeAircraft(Aircraft aircraft) {
        aircrafts.remove(aircraft);
    }
}
