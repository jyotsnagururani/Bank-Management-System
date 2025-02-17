package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton back;
    JLabel image;
    
    MiniStatement(String pin) {
        super("Mini Statement");

        image = new JLabel();
        image.setBounds(20, 140, 400, 200);
        add(image);

        JLabel indianbank = new JLabel("Indian Bank");
        indianbank.setBounds(150, 20, 100, 20);
        add(indianbank);

        JLabel transactiontable = new JLabel();
        transactiontable.setBounds(20, 80, 300, 20);
        add(transactiontable);

        JLabel defaulttable = new JLabel();
        defaulttable.setBounds(20, 400, 300, 20);
        add(defaulttable);

        back = new JButton("Exit");
        back.setBounds(20, 500, 100, 25);
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '" + pin + "'");
            while (rs.next()) {
                String cardNo = rs.getString("cardno"); // Corrected field name
                if (cardNo.length() >= 16) {
                    transactiontable.setText("Card Number: " + cardNo.substring(0, 4) + "XXXXXXXX" + cardNo.substring(11));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '" + pin + "'");
            while (rs.next()) {
                image.setText(image.getText() + "<html>" + rs.getString("date") + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("type") + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("amount") + "<br><br><html>");
                
                if (rs.getString("type").equalsIgnoreCase("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            defaulttable.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
