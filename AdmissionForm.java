package loginForm;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdmissionForm extends Frame implements ActionListener 
{

    TextField t1, t2, t3, t4;
    TextArea ta1;
    Checkbox r1, r2, c1, c2, c3, c4;
    Button submit;

    public AdmissionForm() 
    {
        super("Student Admission Form");
        setSize(550, 600);
        setLayout(null);

        Label l1 = new Label("Applicant First Name");
        Label l2 = new Label("Applicant Middle Name");
        Label l3 = new Label("Applicant Last Name");
        Label l4 = new Label("Select Gender");
        Label l5 = new Label("Residential Address");
        Label l6 = new Label("Programming Skills Known");
        Label l7 = new Label("Email ID");

        CheckboxGroup genderGroup = new CheckboxGroup();
        r1 = new Checkbox("Male", genderGroup, false);
        r2 = new Checkbox("Female", genderGroup, true);

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        t4 = new TextField();
        ta1 = new TextArea();

        c1 = new Checkbox("Java");
        c2 = new Checkbox("Python");
        c3 = new Checkbox("C");
        c4 = new Checkbox("C++");

        submit = new Button("Submit");

        l1.setBounds(30, 50, 150, 20);
        t1.setBounds(200, 50, 300, 25);

        l2.setBounds(30, 90, 150, 20);
        t2.setBounds(200, 90, 300, 25);

        l3.setBounds(30, 130, 150, 20);
        t3.setBounds(200, 130, 300, 25);

        l4.setBounds(30, 170, 150, 20);
        r1.setBounds(200, 170, 80, 25);
        r2.setBounds(290, 170, 80, 25);

        l5.setBounds(30, 210, 150, 20);
        ta1.setBounds(200, 210, 300, 100);

        l6.setBounds(30, 330, 200, 20);
        c1.setBounds(30, 360, 80, 20);
        c2.setBounds(120, 360, 80, 20);
        c3.setBounds(210, 360, 80, 20);
        c4.setBounds(300, 360, 80, 20);

        l7.setBounds(30, 410, 150, 20);
        t4.setBounds(200, 410, 300, 25);

        submit.setBounds(200, 470, 120, 40);

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(r1); add(r2);
        add(l5); add(ta1);
        add(l6); add(c1); add(c2); add(c3); add(c4);
        add(l7); add(t4);
        add(submit);

        submit.addActionListener(this);

        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e) 
            { 
            	System.exit(0); 
            	}
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String languages = "";
        if (c1.getState()) languages += "Java ";
        if (c2.getState()) languages += "Python ";
        if (c3.getState()) languages += "C ";
        if (c4.getState()) languages += "C++ ";

        Connection conn = null;
        PreparedStatement ps = null;

        try 
        {
            conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO form(first_name, middle_name, last_name, gender, address, language, email) VALUES(?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, t1.getText());
            ps.setString(2, t2.getText());
            ps.setString(3, t3.getText());
            ps.setString(4, r1.getState() ? "Male" : "Female");
            ps.setString(5, ta1.getText());
            ps.setString(6, languages);
            ps.setString(7, t4.getText());

            int x = ps.executeUpdate();

            if (x > 0) 
            {
                Dialog d = new Dialog(this, "Success", true);
                d.setSize(230, 120);
                d.setLayout(new FlowLayout());
                d.add(new Label("Form Submitted Successfully!"));
                d.setVisible(true);

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                ta1.setText("");
                c1.setState(false);
                c2.setState(false);
                c3.setState(false);
                c4.setState(false);
            }

        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        } 
        finally 
        {
            try 
            { 
            	if (ps != null) 
            		ps.close(); 
            	if (conn != null) 
            		conn.close(); 
            } 
            catch (Exception ex) 
            {
            	System.out.println("Exception is :"+ex);
            }
        }
    }

    public static void main(String[] args) 
    {
        new AdmissionForm();
    }
}
