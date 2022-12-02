package Labs.Seventh;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {


    static JFrame jFrame = getJFrame();
    static int numb_rows_panel = 2;
    static JPanel jPanel = new JPanel(new GridLayout(numb_rows_panel, 2));
    static JPanel jPanel1 = new JPanel();

    public static void main(String[] args) {
        Airport airport = getAirport();
        JTabbedPane jTabbedPane = new JTabbedPane();
        jFrame.add(jTabbedPane);
        jTabbedPane.add(jPanel, "Info about aircraft");
        jTabbedPane.add(jPanel1, "Passengers");

        showJPanelAircraft(airport);

        showJPanel1Passenger(airport);

        jFrame.pack();
    }

    public static Airport getAirport(){
        Airport airport = new Airport("Pulkovo");
        Aircraft plane1 = new Plane("Boeing 737", 234, 1000);
        airport.addAircraft(plane1);
        Passenger passenger1 = new Passenger("Dair", 100);
        Passenger passenger2 = new Passenger("Ilya", 1);
        plane1.addPassenger(passenger1);
        plane1.addPassenger(passenger2);

        Aircraft plane2 = new Plane("Boeing 747", 350, 1300);
        airport.addAircraft(plane2);
        Passenger passenger3 = new Passenger("Alex", 10);
        Passenger passenger4 = new Passenger("Anastasia", 2);
        plane2.addPassenger(passenger3);
        plane2.addPassenger(passenger4);

        Aircraft helicopter = new Helicopter("HV-24", 3);
        airport.addAircraft(helicopter);
        Passenger passenger5 = new Passenger("John", 1);
        Passenger passenger6 = new Passenger("Alice", 2);
        helicopter.addPassenger(passenger5);
        helicopter.addPassenger(passenger6);
        return airport;
    }

    static JFrame getJFrame() {
        JFrame jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 300, 600, 500);
        jFrame.setTitle("My app");
        return jFrame;
    }

    static void showJPanelAircraft(Airport airport){
        jPanel.removeAll();
        numb_rows_panel = airport.getAircraftList().size();
        jPanel.setLayout(new GridLayout(numb_rows_panel,2));
        for(Aircraft aircraft: airport.getAircraftList()){
            JLabel jLabel = new JLabel(aircraft.getModel());
            JTextArea jTextArea = new JTextArea();
            for(Passenger passenger: aircraft.getPassengerList()){
                jTextArea.append(passenger.toString());
            }

            jPanel.add(jLabel);
            jPanel.add(jTextArea);
        }
    }

    static void showJPanel1Passenger(Airport airport){
        jPanel1.removeAll();

        JButton jButton = new JButton("Select aircraft");

        DefaultListModel<Aircraft> aircraftDefaultListModel = new DefaultListModel<>();
        aircraftDefaultListModel.addAll(airport.getAircraftList());
        JList<Aircraft> aircraftJList = new JList<>(aircraftDefaultListModel);
        jPanel1.add(aircraftJList);
        jPanel1.add(jButton);

        JList<Passenger> jList = new JList<>();
        jPanel1.add(jList);

        JButton jButton1 = new JButton("Fly");
        jPanel1.add(jButton1);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aircraft selectedAircraft = aircraftJList.getSelectedValue();
                DefaultListModel<Passenger> defaultListModel = new DefaultListModel<>();
                defaultListModel.addAll(selectedAircraft.getPassengerList());
                jList.setModel(defaultListModel);

            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = aircraftJList.getSelectedValue().fly();
                JOptionPane.showMessageDialog(jButton, s);
            }
        });






    }


}