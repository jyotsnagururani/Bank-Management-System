package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel transaction, image;
    JButton deposit, withdraw, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;

    Transactions(String pin) {
        this.pinnumber = pin;

        // ATM Image Set करना
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);

        // Transaction Label
        transaction = new JLabel("Please Select Your Transaction");
        transaction.setForeground(Color.WHITE);
        transaction.setFont(new Font("System", Font.BOLD, 16));
        transaction.setBounds(235, 400, 700, 35);
        image.add(transaction);

        // Buttons
        deposit = createButton("DEPOSIT", 170, 499);
        withdraw = createButton("CASH WITHDRAW", 390, 499);
        fastcash = createButton("FAST CASH", 170, 543);
        ministatement = createButton("MINI STATEMENT", 390, 543);
        pinchange = createButton("PIN CHANGE", 170, 588);
        balanceenquiry = createButton("BALANCE ENQUIRY", 390, 588);
        exit = createButton("EXIT", 390, 633);

        // Window Properties
        setLayout(null);
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    // Reusable Method for Creating Buttons
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 35);
        button.addActionListener(this);
        image.add(button);
        return button;
    }

    // Action Listener for Buttons
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (source == withdraw) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (source == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (source == ministatement) {
            new MiniStatement(pinnumber).setVisible(true);
        } else if (source == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (source == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (source == exit) {
            setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
