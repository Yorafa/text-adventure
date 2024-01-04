package addition_part.battle;

import javax.swing.*;
import java.awt.*;

public class BattleStatusPanel extends JPanel {
    private final JLabel nameLabel = new JLabel();
    private final JLabel lvlLabel = new JLabel();
    private final JLabel hpLabel = new JLabel();

    public BattleStatusPanel(String name, int level, int hitPoint, int maxHitPoint) {
        nameLabel.setText(name);
        lvlLabel.setText(String.valueOf(level));
        hpLabel.setText(hitPoint + "/" + maxHitPoint);
        initialize();
    }

    private void initialize() {
        this.setLayout(new GridLayout(3, 1, 10, 10));
        this.add(nameLabel);
        this.add(lvlLabel);
        this.add(hpLabel);
    }
}
