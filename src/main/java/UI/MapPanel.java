package UI;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

    public MapPanel(TextAdventureFrame taf) {
        taf.setContentPane(this);

        this.setLayout(new GridLayout(2, 1, 10, 10));

        JLabel label = new JLabel("Welcome to Text Adventure, " + taf.getUser().getUsername() +
                ". You are currently at " + taf.getMap().getMapName() + "."
                );

        this.add(label);
        // Setup Button Field
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        JButton search = new JButton("Walk around");
        search.addActionListener((e) -> {
            taf.walkAround();
        });

        JButton mapButton = new JButton("Change place");
        mapButton.addActionListener((e) ->
        {
            taf.remove(this);
            taf.setContentPane(new MapChangingPanel(taf));
        });

        JButton browsePokemon = new JButton("Browse pokemon");
        browsePokemon.addActionListener((e) -> {
            // TODO: Pokemon Panel
        });

        JButton logOut = new JButton("Log out");
        logOut.addActionListener((e) -> {
            taf.remove(this);
            LoginPanel loginPanel = new LoginPanel(taf);
            taf.setContentPane(loginPanel);
            taf.setUser(null);
        });

        buttonPanel.add(search);
        buttonPanel.add(mapButton);
        buttonPanel.add(browsePokemon);
        buttonPanel.add(logOut);

        this.add(buttonPanel);
        taf.pack();
    }
}
