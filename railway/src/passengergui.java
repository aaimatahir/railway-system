import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class passengergui extends JFrame implements ActionListener {

    private JTextField nameField, ageField;
    private JRadioButton maleButton, femaleButton;
    private ButtonGroup genderGroup;
    private JButton saveButton;

    public passengergui() {
  
        setTitle("Passenger Details");
        setSize(600, 300);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        add(nameLabel);
        add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        add(ageLabel);
        add(ageField);

        JLabel genderLabel = new JLabel("Gender:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        add(genderLabel);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        add(genderPanel);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        add(new JLabel()); 
        add(saveButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String ageText = ageField.getText();
        String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : null);

        if (name.isEmpty() || ageText.isEmpty() || gender == null) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageText);

            Passenger passenger = new Passenger(name, age, gender);

            JOptionPane.showMessageDialog(null, "Passenger added successfully!\n" + passenger.toString());

            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid age.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        genderGroup.clearSelection();
    }

    public static void main(String[] args) {
        new passengergui();
    }
}
