package Labs.First;

import java.util.ArrayList;

public class Plane extends Aircraft {

    public Plane(String name, int numPass, int distance) throws PolosaRazgonaException{
        super(name, numPass);
        try {
            if (distance <= 0)
                throw new PolosaRazgonaException("Невозможно создать самолет – указана некорректная длина полосы разгона: "
                        + distance);
            else {
                this.distance = distance;
            }
        }
        catch (PolosaRazgonaException polosaRazgonaException){
            System.out.println(polosaRazgonaException.getMessage());
            throw polosaRazgonaException;
        }
    }
    private int distance;

    public int getDistance() {return distance;}
    public void setDistance(int Ndistance) {distance = Ndistance;}


    @Override
    public void fly() {
        try
        {
            super.fly();
        }
        catch (Exception ex){
            System.out.println("Ошибка: " + ex.getMessage());
            ex.printStackTrace();

        }
    }


}