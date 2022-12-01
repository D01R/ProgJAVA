package Labs.Fourth;

import java.util.ArrayList;
public class Airport {
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
    public void addAirctaft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }
    public void removeAircraft(Aircraft aircraft) {
        aircrafts.remove(aircraft);
    }
}
