/*
Mohan Verma
Mr.Mcdonald
Computer Science 20
Henry Wise Wood
Bank Account GUI
*/

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;



class Main implements WindowListener{

    BankAccount chequing;
    BankAccount savings;
    BankAccount current;
    JTextPane currentBalanceText;

    public static void main(String[] args) {
        // creating the Bank Account window
        JFrame frame = new JFrame("Bank Account");
        frame.setSize(261,189);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        Main main = new Main();
        main.parts(panel);
        frame.addWindowListener(main);
        frame.setVisible(true);


    }

    private  void parts(JPanel panel){
        // starting balances
        chequing = new BankAccount("Chequing", 25.897, 0.39, 23847.789);
        savings = new BankAccount("Savings", 279.89, 0.39, 123.789);

        current = chequing;

        panel.setLayout(null);

        // creating the label to prompt the user which account they wish to pick
        JLabel account = new JLabel("Account");
        account.setBounds(10,7,50,25);
        panel.add(account);

        // creating a label that indicates the next item will be the balance in the account
        JLabel currentBalance = new JLabel("Current Balance:");
        currentBalance.setBounds(7,70,100,25);
        panel.add(currentBalance);

        // Area for the balance to be printed
        currentBalanceText = new JTextPane();
        currentBalanceText.setBounds(115,72,120,20);
        currentBalanceText.setEditable(false);
        panel.add(currentBalanceText);
        updateBalance();



        // string that lists the two different account options
        String options[] = {"Chequing", "Savings"};
        // ComboBox function creates the drop box that contains the options for the accounts available
        JComboBox<String> optionList = new JComboBox<>(options);
        optionList.setBounds(115,10,85,25);
        panel.add(optionList);
        //takes the input from the user
        optionList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String optionSelected = (String) optionList.getSelectedItem();
                // runs this if statement if the user picks the chequing account
                if (optionSelected.equals("Chequing")) {
                    current = chequing;
                }
                else if(optionSelected.equals("Savings")) {
                    current = savings;
                }

                updateBalance();
            }
        });

        // creates the Withdraw button
        JButton withdraw = new JButton("Withdraw");
        withdraw.setBounds(10,100,100,25);
        panel.add(withdraw);
        // opens the either chequing or savings based off what the user picks
        withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String optionSelected = (String) optionList.getSelectedItem();
                if (optionSelected.equals("Chequing")) {
                    openWithdrawWindow(chequing);
                }
                else if(optionSelected.equals("Savings")) {
                    openWithdrawWindow(savings);
                }
            }
        });




        // creates the deposit button
        JButton deposit = new JButton("Deposit");
        deposit.setBounds(130,100,100,25);
        panel.add(deposit);
        // opens the either chequing or savings based off what the user picks
        deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String optionSelected = (String) optionList.getSelectedItem();
                if (optionSelected.equals("Chequing")) {
                    openDepositWindow(chequing);
                }
                else if(optionSelected.equals("Savings")) {
                    openDepositWindow(savings);
                }
            }

        });

    }
    // updates the balance based off of code from BankAccount.java
    public void updateBalance() {
        if (current.isOverDrawn()) {
            // if the balance is over drawn then the text color will be set to red
            currentBalanceText.setText(current.toString());
            currentBalanceText.setForeground(Color.red);

        }
        else {
            //if the balance is not over drawn the text color will be set to black
            currentBalanceText.setText(current.toString());
            currentBalanceText.setForeground(Color.black);
        }
    }

    // the methods that open either the deposit or withdraw window based off what the user picks
    public void openDepositWindow(BankAccount account) {
        Deposit d = new Deposit(account);
        d.addWindowListener(this);
        d.setVisible(true);
    }

    public void openWithdrawWindow(BankAccount account) {
        Withdraw w = new Withdraw(account);
        w.addWindowListener(this);
        w.setVisible(true);
    }


    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        updateBalance();

    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}

