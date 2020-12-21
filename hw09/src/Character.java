


import java.util.*;
import java.util.List;

public class Character {
    private String name;
    private String elementtype;
    private int positionX;
    private int positionY;
    private TreeMap<String, Item> itemlist;
//    private LinkedList<Item> gaineditems;
    private int elementalism;
    private int knowledge;
    private String charactericon;
    
    private Item basicitem1;
    private Item basicitem2;
    
    // constructor
    public Character() {
        name = "Elemental";
        elementtype = "Neutral";
//        gaineditems = new LinkedList<Item>();
        
        positionX = 0;
        positionY = 0;
        
        basicitem1 = new Item("Elemental Eye", "Your eye.", "files/icon/elementaleye.png"); // TODO
        basicitem2 = new Item("Offering", "A mysterious gift", "files/icon/offering.png");
        
        itemlist =  new TreeMap<String, Item>();
        itemlist.put("Elemental Eye", basicitem1); 
        itemlist.put("Offering", basicitem2);
//        gaineditems.add(basicitem1);
//        gaineditems.add(basicitem2);
            
        elementalism = 10;
        knowledge = 10;
        charactericon = "files/character/Neutral.png";
        
    }
    
    // methods
    public void changeName(String enteredname) {
        if (enteredname.contains("!")) {
            name = enteredname.replace("!", "");
        } else if (enteredname.isEmpty()) {
            name = "Elemental";
        } else if (enteredname.contains(System.lineSeparator())) {
            name = enteredname.replace(System.lineSeparator(), "");
        } else {
            name = enteredname;
        }
    }
    
    public void changeElement(String newelement) {
        elementtype = newelement;
        charactericon = "files/character/" + newelement + ".png";
    }
    
    public void addElementalism(int add) {
        elementalism += add;
        
        if (elementalism > 50) {
            elementalism = 50;
        }
        
    }
    
    public void addKnowledge(int add) {
        knowledge += add;
        
        if (knowledge > 50) {
            knowledge = 50;
        }
    }
    
    public void changePosition(int x, int y) {
        if ((positionX >= 0) && (positionX < 4) && (x > 0)) {
            positionX = Math.min(positionX + x, 4);
        }
    
        if ((positionX > 0) && (positionX <= 4) && (x < 0)) {
            positionX = Math.max(positionX + x, 0);
        }
        
        if ((positionY >= 0) && (positionY < 4) && (y > 0)) {
            positionY = Math.min(positionY + y, 4);
        }
        
        if ((positionY > 0) && (positionY <= 4) && (y < 0)) {
            positionY = Math.max(positionY + y, 0);
        }
    }
    
    public void takeItem(VastMap map, Item item) {
        if ((! itemlist.containsValue(item)) && (map.containsItem(item))) {
            itemlist.put(item.getItemName(), item);
//            gaineditems.add(item);
            map.removeItem(item);
        }
    }
    
    public boolean containsItem(String ite) {
        return itemlist.containsKey(ite);
    }
    
    public void moveN() {
        if (positionX > 0) {
            positionX--;
        }
    }
    
    public void moveS() {
        if (positionX < 4) {
            positionX++;
        }
    }
    
    public void moveW() {
        if (positionY > 0) {
            positionY--;
        }
    }
    
    public void moveE() {
        if (positionY < 4) {
            positionY++;
        }
    }
    
    // load save file method
    
    public void loadSaveFile(VastMap map, String path) {
        Loader save = new Loader(path);
        String cname = save.readCharacterName();
        String celement = save.readCharacterElement();
        List<Integer> cstats = save.readCharacterStats();
        List<Integer> cposition = save.readCharacterPosition();
        List<String> citems = save.readCharacterItems();
        
        // TODO
        
        name = cname;
        this.changeElement(celement);
        elementalism = (int) cstats.get(0);
        knowledge = (int) cstats.get(1);
        positionX = (int) cposition.get(0);
        positionY = (int) cposition.get(1);
        
        int i = 2; // 0 and 1 are initial items created during initialization!
        while (i < citems.size()) {
            if (citems.get(i).contains("Forest") &&
                    map.containsItemWithName("Forest Flute")) {
                this.takeItem(map, map.getItemFromName("Forest Flute"));
            } else if (citems.get(i).contains("Broken") && 
                    map.containsItemWithName("Broken Mask")) {
                this.takeItem(map, map.getItemFromName("Broken Mask"));
            } else if (citems.get(i).contains("Rust") && 
                    map.containsItemWithName("Rust Blade")) {
                this.takeItem(map, map.getItemFromName("Broken Mask"));
            }
            
            i++;
        }
        
    }
    
    
    // returning methods
    public String getCharacterName() {
        return name;
    }
    
    public String getCharacterElement() {
        return elementtype;
    }
    
    public int getPositionX() {
        return positionX;
    }
    
    public int getPositionY() {
        return positionY;
    }
    
    public TreeMap<String, Item> getItems() {
        return itemlist;
    }
    
    public String displayStats() {
        String t = "Knowledge: " + knowledge + "  | Elementalism: " + elementalism;
        return t;
    }
    
    public int getKnowledge() {
        return knowledge;
    }
    
    public int getElementalism() {
        return elementalism;
    }
    
    public String getCharIconLink() {
        return charactericon;
    }
    
    public Item getSingleItem(String s) {
        if (itemlist.containsKey(s)) {
            return itemlist.get(s);
        }
        return null;
    }
    
//    public List<Item> getItemsListOnly() {
//        return gaineditems;
//    }
}
