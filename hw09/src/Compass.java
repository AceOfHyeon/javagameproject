

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Compass extends JPanel {
    
    private JLabel northborder = new JLabel();
    private JLabel southborder = new JLabel();
    private JLabel westborder = new JLabel();
    private JLabel eastborder = new JLabel();
    private JLabel northwest = new JLabel();
    private JLabel northeast = new JLabel();
    private JLabel southwest = new JLabel();
    private JLabel pointing = new JLabel();
    private JLabel destination = new JLabel();
    
    CardLayout cards = new CardLayout();
    Container co;
    
    Character c;
    
    public Compass(Character mc) {
        c = mc;
        northborder.setText("You're at the northern border of the forest.");
        southborder.setText("You're at the southern border of the forest.");
        westborder.setText("You're at the western border of the forest.");
        eastborder.setText("You're at the eastern border of the forest.");
        northwest.setText("You're at the northwest corner of the forest.");
        northeast.setText("You're at the northeast corner of the forest.");
        southwest.setText("You're at the southwest corner of the forest.");
        
        destination.setText("The Eye stills. This is your final destination.");
        
        pointing.setText("The Eye points south east of the forest.");
        
        
//        co = new Container();
//        this.setLayout(cards);
//        this.add(co);
//        
//        cards.addLayoutComponent(northborder, "N");
//        cards.addLayoutComponent(southborder, "S");
//        cards.addLayoutComponent(westborder, "W");
//        cards.addLayoutComponent(eastborder, "E");
//        cards.addLayoutComponent(northwest, "NW");
//        cards.addLayoutComponent(northeast, "NE");
//        cards.addLayoutComponent(southwest, "SW");
//        cards.addLayoutComponent(pointing, "P");
//        cards.addLayoutComponent(destination, "D");
//        
//        
//        co.add(destination);
//        co.add(eastborder);
//        co.add(northborder);
//        co.add(northeast);
//        co.add(northwest);
//        co.add(pointing);
//        co.add(southborder);
//        co.add(southwest);
//        co.add(westborder);

        northborder.setVisible(true);
        southborder.setVisible(true);
        westborder.setVisible(true);
        eastborder.setVisible(true);
        northwest.setVisible(true);
        northeast.setVisible(true);
        southwest.setVisible(true);
        
//        cards.show(this, "P");
        this.add(northwest);

    }
    
    public void updateDirection() {
        int x = c.getPositionX();
        int y = c.getPositionY();
        
        if (x == 0) {
            if (y == 0) {
                this.removeAll();
                this.add(northwest);
            } else if (y == 4) {
                this.removeAll();
                this.add(northeast);
            } else {
                this.removeAll();
                this.add(northborder);
            }
            
        } else if (x == 4) {
            if (y == 0) {
                this.removeAll();
                this.add(southwest);
            } else if (y == 4) {
                this.removeAll();
                this.add(destination);
            } else {
                this.removeAll();
                this.add(southborder);
            }
            
        } else {
            if (y == 0) {
                this.removeAll();
                this.add(westborder);
            } else if (y == 4) {
                this.removeAll();
                this.add(eastborder);
            } else {
                this.removeAll();
                this.add(pointing);
            }
        }
    }


}
