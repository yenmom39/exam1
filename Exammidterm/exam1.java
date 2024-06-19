import javax.swing.*;
import java.awt.event.*;

public class LockerApplication extends JFrame {
    private String password;
    private JLabel statusLabel;
    private JTextField passwordField;

    public LockerApplication() {
        super("Locker Application");
        password = null;
        JLabel promptLabel = new JLabel("Enter password:");
        passwordField = new JTextField(20);
        JButton enterButton = new JButton("Enter");
        statusLabel = new JLabel("Status: ");


        JPanel panel = new JPanel();
        panel.add(promptLabel);
        panel.add(passwordField);
        panel.add(enterButton);
        panel.add(statusLabel);


        getContentPane().add(panel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);


        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputPassword = passwordField.getText();

                if (password == null) {

                    password = inputPassword;
                    statusLabel.setText("Status: Password Set");
                } else {

                    if (inputPassword.equals(password)) {
                        statusLabel.setText("Status: Correct Password");
                    } else {
                        statusLabel.setText("Status: Incorrect Password");
                    }
                }
                passwordField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LockerApplication();
            }
        });
    }
}
