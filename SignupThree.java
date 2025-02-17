package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JLabel image, accountdetails, accounttype, cardnumber, password, sdnumber, acstatement, pinnumber, code, fdnumber, srequired, formnumber, fNumber;
    JRadioButton saccount, fdaccount, caccount, rdaccount;
    JButton submit, cancel;
    JCheckBox acard, ibanking, mbanking, ealerts, cbook, estatement, statement;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(150, 0, 100, 100);
        add(image);

        accountdetails = new JLabel("Page 3: Account Details");
        accountdetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountdetails.setBounds(280, 40, 400, 40);
        add(accountdetails);

        accounttype = new JLabel("Account Type:");
        accounttype.setFont(new Font("Raleway", Font.BOLD, 18));
        accounttype.setBounds(100, 100, 200, 30);
        add(accounttype);

        saccount = new JRadioButton("Saving Account");
        saccount.setFont(new Font("Raleway", Font.BOLD, 16));
        saccount.setBackground(Color.WHITE);
        saccount.setBounds(100, 140, 200, 30);
        add(saccount);

        fdaccount = new JRadioButton("Fixed Deposit Account");
        fdaccount.setFont(new Font("Raleway", Font.BOLD, 16));
        fdaccount.setBackground(Color.WHITE);
        fdaccount.setBounds(350, 140, 250, 30);
        add(fdaccount);

        caccount = new JRadioButton("Current Account");
        caccount.setFont(new Font("Raleway", Font.BOLD, 16));
        caccount.setBackground(Color.WHITE);
        caccount.setBounds(100, 180, 200, 30);
        add(caccount);

        rdaccount = new JRadioButton("Recurring Deposit Account");
        rdaccount.setFont(new Font("Raleway", Font.BOLD, 16));
        rdaccount.setBackground(Color.WHITE);
        rdaccount.setBounds(350, 180, 250, 30);
        add(rdaccount);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(saccount);
        groupaccount.add(fdaccount);
        groupaccount.add(caccount);
        groupaccount.add(rdaccount);

        cardnumber = new JLabel("Card Number:");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        cardnumber.setBounds(100, 240, 200, 30);
        add(cardnumber);

        password = new JLabel("XXXX-XXXX-XXXX-4184");
        password.setFont(new Font("Raleway", Font.BOLD, 18));
        password.setBounds(330, 240, 250, 30);
        add(password);

        sdnumber = new JLabel("(Your 16-digit Card number)");
        sdnumber.setFont(new Font("Raleway", Font.BOLD, 12));
        sdnumber.setBounds(100, 270, 250, 20);
        add(sdnumber);

        pinnumber = new JLabel("PIN:");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pinnumber.setBounds(100, 310, 200, 30);
        add(pinnumber);

        code = new JLabel("XXXX");
        code.setFont(new Font("Raleway", Font.BOLD, 18));
        code.setBounds(330, 310, 250, 30);
        add(code);

        srequired = new JLabel("Services Required:");
        srequired.setFont(new Font("Raleway", Font.BOLD, 18));
        srequired.setBounds(100, 360, 200, 30);
        add(srequired);

        acard = new JCheckBox("ATM CARD");
        acard.setBackground(Color.WHITE);
        acard.setFont(new Font("Raleway", Font.BOLD, 16));
        acard.setBounds(100, 400, 200, 30);
        add(acard);

        ibanking = new JCheckBox("Internet Banking");
        ibanking.setBackground(Color.WHITE);
        ibanking.setFont(new Font("Raleway", Font.BOLD, 16));
        ibanking.setBounds(350, 400, 200, 30);
        add(ibanking);

        mbanking = new JCheckBox("Mobile Banking");
        mbanking.setBackground(Color.WHITE);
        mbanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mbanking.setBounds(100, 450, 200, 30);
        add(mbanking);

        ealerts = new JCheckBox("EMAIL Alerts");
        ealerts.setBackground(Color.WHITE);
        ealerts.setFont(new Font("Raleway", Font.BOLD, 16));
        ealerts.setBounds(350, 450, 200, 30);
        add(ealerts);

        cbook = new JCheckBox("Cheque Book");
        cbook.setBackground(Color.WHITE);
        cbook.setFont(new Font("Raleway", Font.BOLD, 16));
        cbook.setBounds(100, 500, 200, 30);
        add(cbook);

        estatement = new JCheckBox("E-Statement");
        estatement.setBackground(Color.WHITE);
        estatement.setFont(new Font("Raleway", Font.BOLD, 16));
        estatement.setBounds(350, 500, 200, 30);
        add(estatement);

        statement = new JCheckBox("I hereby declare that the above details are correct.", false);
        statement.setBackground(Color.WHITE);
        statement.setFont(new Font("Raleway", Font.BOLD, 12));
        statement.setBounds(100, 550, 600, 20);
        add(statement);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 600, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 600, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 700);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String atype = null;
            if (saccount.isSelected()) atype = "Saving Account";
            else if (fdaccount.isSelected()) atype = "Fixed Deposit Account";
            else if (caccount.isSelected()) atype = "Current Account";
            else if (rdaccount.isSelected()) atype = "Recurring Deposit Account";

            if (atype == null) {
                JOptionPane.showMessageDialog(null, "Please select an account type.");
                return;
            }

            Random random = new Random();
            String cardnumber = "" +Math.abs(random.nextLong() % 900000000000L + 5040936000000000L);
            String pinnumber = "" +Math.abs(random.nextLong() % 9000L + 1000L);

            String facility = "";
            if (acard.isSelected()) facility += " ATM Card";
            if (ibanking.isSelected()) facility += " Internet Banking";
            if (mbanking.isSelected()) facility += " Mobile Banking";
            if (ealerts.isSelected()) facility += " EMAIL Alerts";
            if (cbook.isSelected()) facility += " Cheque Book";
            if (estatement.isSelected()) facility += " E-Statement";

            try {
                Conn conn = new Conn();
                String query1 = "insert signupthree values('" + formno + "','" + atype + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pinnumber: " + pinnumber);
                new Deposit(pinnumber).setVisible(true);
                setVisible(false);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
