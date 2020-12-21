

import java.io.File;

public class Item {
    private String itemname;
    private String description;
    private String imagelink;
    private File icon;
        
    public Item(String name, String descr, String imagesource) {
        itemname = name;
        description = descr;
        imagelink = imagesource;
        
        icon = new File(imagesource);
        
    }
    
    public String getItemName() {
        return itemname;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getImageLink() {
        return imagelink;
    }
    
}
