package Labs.Sixth;

public class Plane extends Aircraft {
    private int distance;

    public int getDistance() {return distance;}
    public void setDistance(int Ndistance) {distance = Ndistance;}
    public Plane(){}
    public Plane(String name, int numPass, int distance){
        super(name, numPass);
        this.distance=distance;
    }
}
