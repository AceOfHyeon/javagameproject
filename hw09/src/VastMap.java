


import java.util.TreeMap;

public class VastMap {
    private String[][] mapgrid;
    private TreeMap<String, Item> mapitemlist;
        
    public VastMap() {
        mapgrid = new String[5][5];
        mapitemlist = new TreeMap<String, Item>();
    }
    
    // methods
    public void addItemToList(Item it, int x, int y) {
        mapitemlist.put(it.getItemName(), it);
        this.positionItem(it.getItemName(), x, y);
    }
    
    // this method is used by Character class
    public void removeItem(Item item) {
        mapitemlist.remove(item.getItemName());
    }
    
    public boolean characterIsAt(int x, int y, Character c) {
        try {
            if (((!mapgrid[x][y].isEmpty())) && (mapgrid[x][y] != null)) {
                c.takeItem(this, mapitemlist.get(mapgrid[x][y]));
                mapgrid[x][y] = null;
                return true;
            }
            return false;
        } catch (NullPointerException npe) {
            return false;
        }
    }
    
    public String itemAtPos(int x, int y) {
        try {
            if (((!mapgrid[x][y].isEmpty())) && (mapgrid[x][y] != null)) {
                return mapgrid[x][y];
            }
            return "NoItem";
        } catch (NullPointerException npe) {
            return "NoItem";
        }
    }
    
    private void positionItem(String itemname, int x, int y) {
        if ((0 <= x) && (x < 5) && (0 <= y) && (y < 5)) {
            mapgrid[x][y] = itemname;
        }
    }
    
    public Item getItemFromName(String name) {
        if (mapitemlist.containsKey(name)) {
            return mapitemlist.get(name);
        }
        
        return null;
    }
    
    public boolean containsItem(Item it) {
        if (mapitemlist.containsValue(it)) {
            return true;
        }
        return false;
    }
    
    public boolean containsItemWithName(String s) {
        if (mapitemlist.containsKey(s)) {
            return true;
        }
        return false;
    }
    
    public int numberOfRemainingItems() {
        return mapitemlist.size();
    }
    
    
}
