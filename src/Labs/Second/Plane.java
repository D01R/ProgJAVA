package Labs.Second;

import java.util.ArrayList;

public class Plane extends Aircraft {

    public Plane(){
        super();
        System.out.print("������� ����� ������ �������: ");
        this.distance = Input.inputNumber();

    }
    private int distance;

    public int getDistance() {return distance;}
    public void setDistance(int Ndistance) {distance = Ndistance;}
}