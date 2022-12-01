package Labs.Fourth;

public class Plane extends Aircraft {
    private int distance;

    public int getDistance() {return distance;}
    public void setDistance(int Ndistance) {distance = Ndistance;}
    public Plane(String name, int numPass, int distance){
        super(name, numPass);
        this.distance=distance;
    }
    @Override
    public void fly() {
        try {
            super.fly();
        }
        catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
