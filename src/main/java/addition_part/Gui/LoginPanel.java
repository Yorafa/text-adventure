package addition_part.Gui;

import addition_part.GuiDriver.GuiDriver;
import usecase_user.UserManager;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends BasePanel {
    private final UserManager userManager;
    private final JTextField username = new JTextField();
    private final JTextField password = new JTextField();

    public LoginPanel(TextAdventureFrame parent, GuiDriver guiDriver) {
        super(parent, guiDriver);
        this.userManager = guiDriver.getUserManager();
        initialize();
    }

    private void initialize(){
        this.setLayout(new BorderLayout());
        JLabel emptyLabel1 = new JLabel("");
        emptyLabel1.setPreferredSize(new Dimension(0,280));
        JLabel emptyLabel2 = new JLabel("");
        emptyLabel2.setPreferredSize(new Dimension(0,290));
        JLabel emptyLabel3 = new JLabel("");
        emptyLabel3.setPreferredSize(new Dimension(300,0));
        JLabel emptyLabel4 = new JLabel("");
        emptyLabel4.setPreferredSize(new Dimension(300,0));
        this.add(emptyLabel1, BorderLayout.NORTH);
        this.add(emptyLabel2, BorderLayout.SOUTH);
        this.add(emptyLabel3, BorderLayout.WEST);
        this.add(emptyLabel4, BorderLayout.EAST);

        // Setup mainPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        // Setup Text Field
        JTextField username = new JTextField();
        JPanel userPanel = createLine("Username: ", username);
        JTextField password = new JTextField();
        JPanel passPanel = createLine("Password: ", password);
        mainPanel.add(userPanel);
        mainPanel.add(passPanel);

        mainPanel.add(buttonPanel());
        this.add(mainPanel);
    }
    private JPanel buttonPanel(){
        // Setup Button Field
        JPanel buttonPanel = new JPanel();
        JButton login = new JButton("Login");
        login.addActionListener(e -> login());

        JButton register = new JButton("Register");
        register.addActionListener(e -> register());
        buttonPanel.add(login);
        buttonPanel.add(register);
        return buttonPanel;
    }
    private JPanel createLine(String itemName, JTextField field) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(new JLabel(itemName));
        panel.add(field);
        return panel;
    }

    private void login(){
        if (userManager.login(username.getText(), password.getText())) {
            parent.remove(this);
            guiDriver.setUp(username.getText());
            parent.explorePanel();
        } else {
            String message = "Either your username not exist or wrong password";
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);

        }
    }

    private void register(){
        if (userManager.hasUser(username.getText())) {
            String message = "Your name already been used";
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String message = "You are successful registered";
            JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.WARNING_MESSAGE);
            parent.remove(this);
            guiDriver.setUp(username.getText());
            parent.initialPanel();
        }
    }
}
