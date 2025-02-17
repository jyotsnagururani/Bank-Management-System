package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField amountField;
    JButton deposit, back;
    JLabel text, image;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Deposit Money");

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);

        // Instruction Label
        text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 350, 400, 35);
        image.add(text);

        // Amount Input Field
        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountField.setBounds(190, 420, 320, 25);
        image.add(amountField);

        // Deposit Button
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(390, 588, 150, 35);
        deposit.addActionListener(this);
        image.add(deposit);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(390, 633, 150, 35);
        back.addActionListener(this);
        image.add(back);

        // Frame properties
        setLayout(null);
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String amount = amountField.getText();
            Date date = new Date();

                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit.");
                } else {
                    try {
                       Conn conn = new Conn();
                       String query = "insert into bank values ('" + pinnumber + "', '" + date + "', 'Deposit', '" + amount + "')";
                       conn.s.executeUpdate(query);
                       JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                       setVisible(false);
                       new Transactions(pinnumber).setVisible(true);
                    } catch (Exception e) {
                          System.out.println(e);
                    }
                }    
            } else if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
