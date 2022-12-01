package Labs.Five;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AirportReport{
    public static void create_save(Airport airport, String repName) throws IOException {
        String reportName = "F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Five\\"+ repName +".txt";
        FileOutputStream newReport = new FileOutputStream(reportName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(newReport);
        objectOutputStream.writeObject(airport);
        newReport.close();
        objectOutputStream.close();
    }
    public static String readReport(String repName)throws IOException, ClassNotFoundException{
        String reportName = "F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Five\\" +repName + ".txt";
        FileInputStream report = new FileInputStream(reportName);
        ObjectInputStream objectInputStream = new ObjectInputStream(report);

        Airport airport = (Airport)objectInputStream.readObject();

        ArrayList<Aircraft> crafts = airport.getAircrafts();
        String sreport = airport.getName()+'\n';
        for (Aircraft craft: crafts){
            sreport += "Летательный аппарат: " + craft.getModel() + '\n'+'\n';
            ArrayList<Passenger> passengers = craft.getPassengers();
            int i =1;
            for (Passenger pers: passengers){
                sreport+= "Пассажир " +(i++) +": " + pers.getName() + " | " + pers.getPlace() + '\n';
            }
            sreport += "-".repeat(20) + '\n';
            sreport += "Текущее кол-во пассажиров: " + passengers.size() + '\n';
            sreport += "Максимальное кол-во пассажиров: " + craft.getNumPass() + '\n'+'\n';
        }

        report.close();
        objectInputStream.close();
        return sreport;
    }



}
