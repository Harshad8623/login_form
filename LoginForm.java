package loginForm;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class LoginForm extends Frame implements ActionListener {

    TextField tfFName, tfMName, tfLName, tfAge, tfAddress;
    Choice genderChoice;
    Button btnSubmit;

    public LoginForm() {

        setLayout(new GridLayout(8, 2));

        add(new Label("First Name:"));
        tfFName = new TextField();
        add(tfFName);

        add(new Label("Middle Name:"));
        tfMName = new TextField();
        add(tfMName);

        add(new Label("Last Name:"));
        tfLName = new TextField();
        add(tfLName);

        add(new Label("Gender:"));
        genderChoice = new Choice();
        genderChoice.add("Male");
        genderChoice.add("Female");
        genderChoice.add("Other");
        add(genderChoice);

        add(new Label("Age:"));
        tfAge = new TextField();
        add(tfAge);

        add(new Label("Address:"));
        tfAddress = new TextField();
        add(tfAddress);

        btnSubmit = new Button("Submit");
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        setTitle("Student / User Registration Form");
        setSize(400, 300);
        setVisible(true);

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            try {
                Connection con = DatabaseConnection.getConnection();
                String query = "INSERT INTO users (firstname, middlename, lastname, gender, age, address) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, tfFName.getText());
                ps.setString(2, tfMName.getText());
                ps.setString(3, tfLName.getText());
                ps.setString(4, genderChoice.getSelectedItem());
                ps.setInt(5, Integer.parseInt(tfAge.getText()));
                ps.setString(6, tfAddress.getText());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Form Submitted Successfully!");

                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
