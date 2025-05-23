import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ticketgui extends JFrame {
    private ArrayList<Ticket> ticketList;
    private JTable ticketTable;
    private DefaultTableModel tableModel;

    public Ticketgui() {
        ticketList = new ArrayList<>();
        createGUI();
    }

    private void createGUI() {
        setTitle("Ticket Management System");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] columns = {"Train Name", "Passenger Name", "Seat Number"};
        tableModel = new DefaultTableModel(columns, 0);
        ticketTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(ticketTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JLabel trainLabel = new JLabel("Train Name:");
        JTextField trainField = new JTextField();
        JLabel passengerLabel = new JLabel("Passenger Name:");
        JTextField passengerField = new JTextField();
        JLabel seatLabel = new JLabel("Seat Number:");
        JTextField seatField = new JTextField();

        JButton addButton = new JButton("Add Ticket");
        JButton removeButton = new JButton("Remove Ticket");

        formPanel.add(trainLabel);
        formPanel.add(trainField);
        formPanel.add(passengerLabel);
        formPanel.add(passengerField);
        formPanel.add(seatLabel);
        formPanel.add(seatField);
        formPanel.add(addButton);
        formPanel.add(removeButton);

        add(formPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String trainName = trainField.getText();
                String passengerName = passengerField.getText();
                int seatNumber = Integer.parseInt(seatField.getText());

                
                Train train = new Train(trainName, "Destination", "Time", 100); 
                Passenger passenger = new Passenger(passengerName, 30, "gender"); 
                Ticket ticket = new Ticket(train, passenger, seatNumber);
                ticketList.add(ticket);

                tableModel.addRow(new Object[]{train.getTrainName(), passenger.getName(), ticket.getSeatNumber()});

                trainField.setText("");
                passengerField.setText("");
                seatField.setText("");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = ticketTable.getSelectedRow();
                if (selectedRow != -1) {
                    ticketList.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a ticket to remove.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ticketgui();
    }
}
