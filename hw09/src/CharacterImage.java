

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CharacterImage extends JPanel implements ImageInterface {
    private String filepath;
    private String iconname;
    
    private BufferedImage neutral;
    private BufferedImage shadow;
    private BufferedImage light;
    private BufferedImage air;
    private BufferedImage fire;
    private BufferedImage water;
    
    private JLabel icon;
    private JLabel description;
    
    private Character c;
    
    public CharacterImage(Character mc) {
        c = mc;
        
        neutral = makePathToImage("files/character/Neutral.png");
        shadow = makePathToImage("files/character/Shadow.png");
        light = makePathToImage("files/character/Light.png");
        air = makePathToImage("files/character/Air.png");
        water = makePathToImage("files/character/Water.png");
        fire = makePathToImage("files/character/Fire.png");
                
        if (mc.getCharacterElement() == "Shadow") {
            icon = new JLabel(new ImageIcon(shadow));
            iconname = "Shadow";
        } else if (mc.getCharacterElement() == "Light") {
            icon = new JLabel(new ImageIcon(light));
            iconname = "Light";
        } else if (mc.getCharacterElement() == "Air") {
            icon = new JLabel(new ImageIcon(air));
            iconname = "Air";
        } else if (mc.getCharacterElement() == "Water") {
            icon = new JLabel(new ImageIcon(water));
            iconname = "Water";
        } else if (mc.getCharacterElement() == "Fire") {
            icon = new JLabel(new ImageIcon(fire));
            iconname = "Fire";
        } else {
            icon = new JLabel(new ImageIcon(neutral));
            iconname = "Neutral";
        }
        
        filepath = "files/character/" + iconname + ".png";
        
        this.add(icon);

    }
    
    private static BufferedImage makePathToImage(String p) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(p));
            return image;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public String getFilePath() {
        return filepath;
    }

    @Override
    public String getIconName() {
        return iconname;
    }
    
    @Override
    public BufferedImage getBImage() {
        return makePathToImage(filepath);
    }

    @Override
    public JLabel getLabel() {
        return icon;
    }

    @Override
    public void changeIcon(String s) { // updates according to character change
        this.remove(icon);
        
        if (c.getCharacterElement().contains("Shadow")) {
            icon = new JLabel(new ImageIcon(shadow));
            iconname = "Shadow";
            filepath = "files/character/" + iconname + ".png";
            
            this.add(icon);
        } 
        
        if (c.getCharacterElement().contains("Light")) {
            icon = new JLabel(new ImageIcon(light));
            iconname = "Light";
            filepath = "files/character/" + iconname + ".png";
            
            this.add(icon);
        } 

        if (c.getCharacterElement().contains("Air")) {
            icon = new JLabel(new ImageIcon(air));
            iconname = "Air";
            filepath = "files/character/" + iconname + ".png";
            
            this.add(icon);
        } 

        if (c.getCharacterElement().contains("Water")) {
            icon = new JLabel(new ImageIcon(water));
            iconname = "Water";
            filepath = "files/character/" + iconname + ".png";
            
            this.add(icon);
        } 

        if (c.getCharacterElement().contains("Fire")) {
            icon = new JLabel(new ImageIcon(fire));
            iconname = "Fire";
            filepath = "files/character/" + iconname + ".png";
            
            this.add(icon);
        } 

        if (c.getCharacterElement().contains("Neutral")) {
            icon = new JLabel(new ImageIcon(neutral));
            iconname = "Neutral";
            filepath = "files/character/" + iconname + ".png";
            
            this.add(icon);
        }
                
    }

    @Override
    public void addDescription(String s) {
        description = new JLabel();
        description.setText(s);
        description.setBackground(Color.black);
        this.add(description, BorderLayout.SOUTH);
    }

    @Override
    public void removeDescription() {
        if (description.isValid()) {
            this.remove(description);
        }
    }

}
