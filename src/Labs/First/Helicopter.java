package Labs.First;

public class Helicopter extends Aircraft{
    public Helicopter(String name, int numPass){
        super(name, numPass);
    }

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