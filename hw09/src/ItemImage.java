

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ItemImage extends JPanel implements ImageInterface {

    private String itemlist;
    private String filepath;
    private TreeMap<String, JLabel> itemimgs;
    private Character c;
    
    private String eepath;
    private String opath;
    
    private JLabel recentpic;
    private JLabel description;
    
    public ItemImage(Character mc) {
        TreeMap<String, Item> t = mc.getItems();
        itemimgs = new TreeMap<String, JLabel>();
        GridLayout inventorylayout = new GridLayout(0, 3);
        this.setLayout(inventorylayout);
        
        eepath = t.get("Elemental Eye").getImageLink();
        opath = t.get("Offering").getImageLink();
        
        JLabel eleye = new JLabel(new ImageIcon(makePathToImage(eepath)));
        JLabel off = new JLabel(new ImageIcon(makePathToImage(opath)));
        
        itemimgs.put(eepath, eleye);
        itemimgs.put(opath, off);
        
        this.add(eleye);
        this.add(off);
        
        recentpic = off;
        
        itemlist = "Elemental Eye" + ", " + "Offering";
        filepath = opath;
        
        c = mc;
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
    
    public void updateInventory(Character mc) {
        c = mc;
        itemlist = "";
        
        Iterator<String> iter = mc.getItems().navigableKeySet().iterator();
        
        while (iter.hasNext()) {
            itemlist = itemlist + iter.next() + " | ";
        }
        
    }
    
    // after doing changeIcon(which adds a jlabel to the panel, always call updateInventory.
    // if description label exists, remove then re-add that too.
    // especially after updating images when loading a save!
    @Override
    public void changeIcon(String s) { // add item image when given item link!
        if (! itemimgs.containsKey(s)) {
            JLabel t = new JLabel(new ImageIcon(makePathToImage(s)));
            itemimgs.put(s, t);
            recentpic = t;
            filepath = s;
            this.add(t);
        }
    }
    
    public void addMass(TreeMap<String, Item> tm, Character m) {
        if (tm.containsKey("Elemental Eye")) {
            tm.remove("Elemental Eye");
        }
        
        if (tm.containsKey("Offering")) {
            tm.remove("Offering");
        }
        
        Item[] itemarray = (Item[]) tm.values().toArray();
        
        for (int i = 0; i < itemarray.length; i++) {
            this.changeIcon(itemarray[i].getImageLink());
        }
        
        this.updateInventory(m);
    }
    
    @Override
    public String getFilePath() {
        return filepath;
    }

    @Override
    public String getIconName() {
        return itemlist;
    }

    @Override
    public BufferedImage getBImage() {
        return makePathToImage(filepath);
    }

    @Override
    public JLabel getLabel() {
        return recentpic;
    }

    @Override
    public void addDescription(String s) {
        description = new JLabel();
        description.setText(itemlist);
        description.setBackground(Color.white);
        this.add(description);
    }

    @Override
    public void removeDescription() {
        if (description.isValid()) {
            this.remove(description);
        }
    }

}
