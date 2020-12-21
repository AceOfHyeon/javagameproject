

import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public interface ImageInterface {
    public String getFilePath();
    
    // for Scene and Character, will return name of current image.
    /* for Item, getIconName will return String of all images currently shown in the panel 
     * separated by commas - needed for inventory listing */
    public String getIconName();
    
    // of latest image
    public BufferedImage getBImage();
    public JLabel getLabel();
    
    // for SceneImage, will change image to new.
    // for ItemImage, will add new image into panel. 
    // for CharacterImage, will change icon into one of 6 predefined images
    // (instantiated when obj is created)
    public void changeIcon(String s); 
    
    // for Character and Scene, adds text label underneath image.
    // for Item, adds a TextArea (uneditable) that lists all images shown by item name
    public void addDescription(String s);
    
    // removes description label
    public void removeDescription();
    
}
