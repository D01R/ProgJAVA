package Labs.Fourth;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AirportReport{
    public static void create_saveB(Airport airport, String repName) throws IOException {
        String reportName = "F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Fourth\\"+ repName +".txt";
        FileOutputStream newReport = new FileOutputStream(reportName);
        ArrayList<Aircraft> crafts = airport.getAircrafts();
        String report = airport.getName()+'\n';
        for (Aircraft craft: crafts){
            report += "Летательный аппарат: " + craft.getModel() + '\n'+'\n';
            ArrayList<Passenger> passengers = craft.getPassengers();
            int i =1;
            for (Passenger pers: passengers){
                report+= "Пассажир " +(i++) +": " + pers.getName() + " | " + pers.getPlace() + '\n';
            }
            report += "-".repeat(20) + '\n';
            report += "Текущее кол-во пассажиров: " + passengers.size() + '\n';
            report += "Максимальное кол-во пассажиров: " + craft.getNumPass() + '\n'+'\n';
        }
        newReport.write(report.getBytes());
        newReport.close();
    }
    public static String readReportB(String repName)throws IOException{
        String reportName = "F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Fourth\\" +repName + ".txt";
        FileInputStream report = new FileInputStream(reportName);
        String reportString = new String(report.readAllBytes());
        report.close();
        return reportString;
    }


    public static void create_saveCh(Airport airport, String repName) throws IOException{
        String reportName = "F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Fourth\\" +repName + ".txt";
        FileWriter newReport = new FileWriter(reportName);
        ArrayList<Aircraft> crafts = airport.getAircrafts();
        String report = airport.getName() + '\n';
        for (Aircraft craft: crafts){
            report += "Летательный аппарат: " + craft.getModel() + '\n'+'\n';
            ArrayList<Passenger> passengers = craft.getPassengers();
            int i = 1;
            for (Passenger pers: passengers){
                report+= "Пассажир " + (i++) + ": " + pers.getName() + " | " + pers.getPlace() + '\n';
            }
            report += "-".repeat(20) + '\n';
            report += "Текущее кол-во пассажиров: " + passengers.size() + '\n';
            report += "Максимальное кол-во пассажиров: " + craft.getNumPass() + '\n'+ '\n';
        }
        newReport.write(report);
        newReport.close();
    }
    public static String readReportCh(String repName)throws IOException{
        String reportName = "F:\\Storage\\Академ разница\\Программировние Java\\ProgJAVA\\src\\Labs\\Fourth\\" +repName + ".txt";
        FileReader report = new FileReader(reportName);
        String reportString ="";
        while (report.ready()){
            reportString += (char) report.read();
        }
        report.close();
        return reportString;
    }
}
