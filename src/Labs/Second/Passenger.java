package Labs.Second;

public class Passenger {
    public Passenger(){
        this.name = Input.inputLine();
        this.place = Input.inputNumber();
        //this.name = ScannerInput.inputLine();
        //this.place = ScannerInput.inputNumber();

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