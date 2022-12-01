package Labs.Second;

public class Main {
    public static void main(String[] args) {
        Plane craft = new Plane();
        System.out.println("Самолёт " + craft.getModel() + ". Может переносить " + craft.getNumPass()
                + " пассажиров. И нуждается в полосе разгона длиной: "+ craft.getDistance());

    }
}
