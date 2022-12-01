package Labs.Fourth;

public class Helicopter extends Aircraft{
    public Helicopter(String name, int numPass){
        super(name, numPass);
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
