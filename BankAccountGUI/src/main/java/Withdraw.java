import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import java.awt.event.WindowEvent;

public class Withdraw extends JFrame{
    JPanel panel = new JPanel();
    public Withdraw(BankAccount account) {
        // settings of the window
        this.setTitle("Withdraw");
        this.setSize(280,150);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.add(panel);
        parts(panel, account);

    }

    private void parts(JPanel panel, BankAccount account) {
        panel.setLayout(null);

        // label to prompt the user asking how much they wish to withdraw
        JLabel withdrawLabel = new JLabel("Provide the amount to be withdrawed");
        withdrawLabel.setBounds(5,0,270,20);
        panel.add(withdrawLabel);

        // text field where user inputs the amount
        JTextField amountText = new JTextField();
        amountText.setBounds(10,45,240,25);
        panel.add(amountText);

        // button that confirms the amount the user provided
        JButton ok = new JButton("OK");
        ok.setMargin(new Insets(0,0,0,0));
        ok.setBounds(70,75,60,25);
        panel.add(ok);

        // withdraws from balance
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountText.getText());
                account.withdraw(amount);
                finished();
            }
        });


        // if the user doesn't want to withdraw any longer they can cancel and brings them back to the main page
        JButton cancel = new JButton("Cancel");
        cancel.setMargin(new Insets(0,0,0,0));
        cancel.setBounds(140,75,60,25);
        panel.add(cancel);

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finished();
            }
        });
    }

    // disposes the window
    private void finished() {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
    }

}
