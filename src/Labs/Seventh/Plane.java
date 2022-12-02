package Labs.Seventh;

public class Plane extends Aircraft {

    private int distance;

    public Plane(String model, int numPass, int distance) {
        super(model, numPass);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}