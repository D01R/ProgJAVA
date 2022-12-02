package Labs.Seventh;

public class Passenger {
    private String fullName;
    private int place;

    public Passenger(String fullName, int place) {
        this.fullName = fullName;
        this.place = place;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Passenger: " +
                "full Name='" + fullName + '\'' +
                ", place=" + place + "\n";
    }
}