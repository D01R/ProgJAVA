package Labs.Second;

public class Airport {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
    public Airport (){
        this.name = Input.inputLine();
        //this.name = ScannerInput.inputLine();
    }
}
