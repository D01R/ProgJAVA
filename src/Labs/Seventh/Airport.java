package Labs.Seventh;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String name;
    private final List<Aircraft> aircraftList = new ArrayList<>();

    public Airport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }
}