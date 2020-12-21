

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StatShower extends JPanel {
    private JLabel stats;
    private Character c;
    private String output;
    
    public StatShower(Character mc) {
        c = mc;
                        
        output = c.displayStats();
        
        stats = new JLabel();
        stats.setText(output);
        stats.setVisible(true);
        
        this.add(stats, BorderLayout.NORTH);
    }
    
    public void updateStats() {
        this.remove(stats);
        output = c.displayStats();
        
        stats = new JLabel();
        stats.setText(output);
        stats.setVisible(true);
        
        this.add(stats);
    }
    
}
