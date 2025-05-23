import javax.swing.*;
import java.awt.*;

public class Traingui extends JFrame {

    public Traingui() {
        setTitle("Available Trains");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[][] trainData = {
            {"Express 101", "City A", "08:00 AM"},
            {"Express 102", "City B", "10:30 AM"},
            {"Express 103", "City C", "01:00 PM"},
            {"Express 104", "City D", "04:15 PM"},
            {"Express 105", "City E", "07:45 PM"}
        };

        String[] columnNames = {"Train Name", "Destination", "Departure Time"};

        JTable trainTable = new JTable(trainData, columnNames);
        JScrollPane scrollPane = new JScrollPane(trainTable);
        trainTable.setFillsViewportHeight(true);

        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void main(String[] args) {
        new Traingui();
    }
}
