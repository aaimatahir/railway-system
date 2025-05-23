import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boardingpassgui extends JFrame {
    private Ticket ticket;

    public Boardingpassgui() {
        createGUI();
    }

    private void createGUI() {
        setTitle("Boarding Pass");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(5, 2));

        JLabel trainLabel = new JLabel("Train Name:");
        JTextField trainfield = new JTextField();
        JLabel passengerLabel = new JLabel("Passenger:");
        JTextField passengerfield = new JTextField();
        JLabel seatLabel = new JLabel("Seat Number:");
        JTextField seatfield = new JTextField();

        JButton addButton = new JButton("Add Ticket");
        JButton printButton = new JButton("Print Boarding Pass");

        add(trainLabel);
        add(trainfield);
        add(passengerLabel);
        add(passengerfield);
        add(seatLabel);
        add(seatfield);
        add(addButton);
        add(printButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String trainName = trainfield.getText();
                    String passengerName = passengerfield.getText();
                    int seatNumber = Integer.parseInt(seatfield.getText());

                    Passenger passenger = new Passenger(passengerName, 25,"gender");  
                    System.out.println("Passenger created: " + passenger.getName()); 

                    Train train = new Train(trainName, "Kashmir", "08:00 AM", 40);

                    ticket = new Ticket(train, passenger, seatNumber);
                    System.out.println("Ticket created for passenger: " + ticket.getPassenger().getName()); 

                    trainfield.setText("");
                    passengerfield.setText("");
                    seatfield.setText("");

                    JOptionPane.showMessageDialog(null, "Ticket added!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid seat number.");
                }
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ticket != null) {
                    Passenger passenger = ticket.getPassenger();
                    Train train = ticket.getTrain();

                    if (passenger != null && passenger.getName() != null) {
                        String message = "====== Boarding Pass ======\n" +
                                "Passenger Name: " + passenger.getName() + "\n" +
                                "Train Name: " + train.getTrainName() + "\n" +
                                "Destination: " + train.getDestination() + "\n" +
                                "Seat Number: " + ticket.getSeatNumber() + "\n" +
                                "===========================";

                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "Passenger data is missing.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No ticket available. Please add a ticket first.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Boardingpassgui();
    }
}
