package Labs.Sixth;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AirportReport{
    public static void create_save(Airport airport, String repName) throws IOException {
        String reportName = "F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Sixth\\"+ repName +".xml";
        FileOutputStream newReport = new FileOutputStream(reportName);
        XMLEncoder encoder = new XMLEncoder(newReport);
        encoder.writeObject(airport);
        encoder.close();
        newReport.close();
    }
    public static String readReport(String repName)throws IOException, ClassNotFoundException{
        String reportName = "F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Sixth\\" +repName + ".xml";
        FileInputStream report = new FileInputStream(reportName);
        XMLDecoder decoder = new XMLDecoder(report);
        Airport airport = (Airport)decoder.readObject();
        decoder.close();
        report.close();
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


        return sreport;
    }



}