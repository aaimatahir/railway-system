import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Home extends JFrame{

    public Home(){
        setTitle("Raiway managnment System");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));

        JButton train = new JButton("Train");
        JButton passenger = new JButton("Passenger");
        JButton ticket = new JButton("Ticket ");
        JButton boardingpass = new JButton("Boarding pass");

        train.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new Traingui();
            }
        });
        passenger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new passengergui();
            }
        });
        ticket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ticketgui();
            }
        });

        boardingpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Boardingpassgui();
            }
        });
        add(train);
        add(passenger);
        add(ticket);
        add(boardingpass);

        setLocationRelativeTo(null);
        setVisible(true);
        

    }
    public static void main(String[] args) {
        new Home();
    }
}