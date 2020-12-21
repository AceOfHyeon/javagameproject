

import java.awt.BorderLayout;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SceneImage extends JPanel implements ImageInterface {

    private String filepath;
    private String iconname;
    private BufferedImage image;
    private JLabel icon;
    private JLabel description;
    
    public SceneImage(String path, String name) {
        try {                
            image = ImageIO.read(new File(path));
            filepath = path;
            iconname = name;
            icon = new JLabel(new ImageIcon(image));
            icon.setBounds(0, 0, 20, 20);
            this.add(icon);
            this.setBounds(0, 0, 20, 20);
            this.repaint();
            
        } catch (IOException ex) {
            filepath = "files/icon/empty.png";
            iconname = "empty";
        }
    }
    
    @Override
    public void changeIcon(String path) {
        try {
            this.removeAll();
            image = ImageIO.read(new File(path));
            filepath = path;
//            iconfile = new File(path);
            icon = new JLabel(new ImageIcon(image));
            icon.setBounds(0, 0, 30, 30);
            this.add(icon);
            this.repaint();
        } catch (IOException ex) {
            filepath = "files/icon/empty.png";
            iconname = "empty";
        }
    }
    
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawImage(image, 0, 0, this);           
//    }
    
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
        return image;
    }

    @Override
    public JLabel getLabel() {
        return icon;
    }

    @Override
    public void addDescription(String s) {
        description = new JLabel();
        description.setText(s);
        this.add(description, BorderLayout.SOUTH);
    }

    @Override
    public void removeDescription() {
        if (description.isValid()) {
            this.remove(description);
        }
    }
}
