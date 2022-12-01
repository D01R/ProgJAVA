package Labs.First;

public class Passenger {
    public Passenger(String name, int place){
        this.name = name;
        this.place = place;

    }
    private String name;
    private Aircraft aircraft;
    public Aircraft getAir() {return aircraft;}
    public void setAir(Aircraft aircraft) {this.aircraft = aircraft;}

    public String getName() {return name;}
    public void setName(String newName) {name = newName;}

    private int place;
    public int getPlace() {return place;}
    public void setnPlace(int newPlace) {place = newPlace;}


}