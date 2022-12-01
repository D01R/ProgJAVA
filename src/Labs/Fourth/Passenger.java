package Labs.Fourth;

public class Passenger {
    public Passenger(String name, int place){
        this.name = name;
        this.place = place;
    }
    private String name;
    public String getName() {return name;}
    public void setName(String newName) {name = newName;}

    private int place;
    public int getPlace() {return place;}
    public void setnPlace(int newPlace) {place = newPlace;}

    private Plane plane;
    public Plane getPlane() {return plane;}
    public void setPlane(Plane Pplane) {plane = Pplane;}
}
