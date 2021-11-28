package UI;

import gateway.*;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    public LoginPanel(TextAdventureFrame taf) {
        taf.setContentPane(this);
        // Setup mainPanel
        this.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        this.setLayout(new GridLayout(3, 1));

        // Setup Text Field
        JTextField username = new JTextField();
        JPanel userPanel = createLine("Username: ", username);
        JTextField password = new JTextField();
        JPanel passPanel = createLine("Password: ", password);
        this.add(userPanel);
        this.add(passPanel);

        // Setup Button Field
        JPanel buttonPanel = new JPanel();
        JButton login = new JButton("Login");
        login.addActionListener((e) -> {
            taf.setUser(taf.getUserManager().login(username.getText(), password.getText()));
            if (taf.getUser() == null) {
                String message = "Either your username not exist or wrong password";
                JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                taf.setContentPane(new MapPanel(taf));
            }
        });

        JButton register = new JButton("Register");
        register.addActionListener((e) -> {
            taf.setUser(taf.getUserManager().register(username.getText(), password.getText()));
            if (taf.getUser() == null) {
                String message = "Your name already been used or\n" +
                        "Your password is doesn't match requirement:\n" +
                        "length 6-16, consist with numbers and characters";
                JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                String message = "You are successful registered";
                JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
                UserGate.writeUM(taf.getUserManager());
                taf.setContentPane(new MapPanel(taf));
            }
        });
        buttonPanel.add(login);
        buttonPanel.add(register);

        this.add(buttonPanel);
    }

    public JPanel createLine(String itemName, JTextField field) {
        JPanel panel = new JPanel();
        field.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
        panel.setLayout(new GridLayout(1, 2));
        panel.add(new JLabel(itemName));
        panel.add(field);
        return panel;
    }
}
