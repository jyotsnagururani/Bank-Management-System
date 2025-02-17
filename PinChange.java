package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pfield, jfield;
    JButton change, back;                               
    JLabel cypin, pin, repin, image;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);
        
        cypin = new JLabel("CHANGE YOUR PIN");
        cypin.setFont(new Font("System", Font.BOLD, 16));
        cypin.setForeground(Color.WHITE);
        cypin.setBounds(280, 330, 800, 35);
        image.add(cypin);
        
        pin = new JLabel("New PIN:");
        pin.setFont(new Font("System", Font.BOLD, 16));
        pin.setForeground(Color.WHITE);
        pin.setBounds(180, 390, 150, 35);
        image.add(pin);
        
        repin = new JLabel("Re-Enter New PIN:");
        repin.setFont(new Font("System", Font.BOLD, 16));
        repin.setForeground(Color.WHITE);
        repin.setBounds(180, 440, 200, 35);
        image.add(repin);
        
        pfield = new JPasswordField();
        pfield.setFont(new Font("Raleway", Font.BOLD, 25));
        pfield.setBounds(350, 390, 180, 25);
        image.add(pfield);
        
        jfield = new JPasswordField();
        jfield.setFont(new Font("Raleway", Font.BOLD, 25));
        jfield.setBounds(350, 440, 180, 25);
        image.add(jfield);
        
        change = new JButton("CHANGE");
        change.addActionListener(this);
        change.setBounds(390, 588, 150, 35);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(390, 633, 150, 35);
        back.addActionListener(this);
        image.add(back);
        
        setLayout(null);
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == change) {
        try {
            String npin = new String(pfield.getPassword());  
            String rpin = new String(jfield.getPassword()); 

            if (npin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                return;
            }

            if (rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                return;
            }

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            Conn conn = new Conn();
                
                String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Error occurred while changing the PIN.");
        }
    } else {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}



    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
