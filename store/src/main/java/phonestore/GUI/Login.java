package phonestore.GUI;

import javax.swing.*;

public class Login extends JFrame {
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        JLabel lblUsername = new JLabel("Username");

    }
}
