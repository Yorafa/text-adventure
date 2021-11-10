package UI;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {

    public MapPanel(TextAdventureFrame taf){
        taf.setContentPane(this);
        this.setBorder(BorderFactory.createEmptyBorder(100,50,50,50));
        this.setLayout(new GridLayout(2,1,10,10));

        JLabel label = new JLabel("Welcome to Text Adventure, " + taf.getUser().getName());
        this.add(label);
        // Setup Button Field
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2,10,10));
        JButton search = new JButton("Walk around");
        search.addActionListener((e) -> {
            // TODO: Map walk around
        });

        JButton mapButton = new JButton("Change place");
        mapButton.addActionListener((e) -> {
            // TODO: Change Map
        });

        JButton browsePokemon = new JButton("Browse pokemon");
        browsePokemon.addActionListener((e) -> {
            // TODO: Pokemon Panel
        });

        JButton logOut = new JButton("Log out");
        logOut.addActionListener((e) -> {
            taf.setContentPane(new LoginPanel(taf));
            taf.setUser(null);
        });

        buttonPanel.add(search);
        buttonPanel.add(mapButton);
        buttonPanel.add(browsePokemon);
        buttonPanel.add(logOut);

        this.add(buttonPanel);

    }
}
