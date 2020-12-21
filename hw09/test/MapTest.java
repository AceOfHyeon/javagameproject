

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    
    private VastMap map;
    private Item i;
    private Item ii;
    
    @BeforeEach 
    public void setup(){
        map  = new VastMap();
        i = new Item("i1", "this is i1", "i1link");
        ii = new Item("i2", "this is i2", "i2link");
    }
    
    @Test
    public void testAdd() {
        map.addItemToList(i, 0, 3);
        map.addItemToList(ii, 3, 0);
        
        assertTrue(map.containsItem(i));
        
        assertEquals(map.itemAtPos(0, 3), "i1");
        assertEquals(map.itemAtPos(3, 0), "i2");
    }
    
    @Test
    public void testRemove() {
        
        map.addItemToList(i, 1, 1);
        
        System.out.println(map.itemAtPos(1, 1));
        assertEquals(map.itemAtPos(1, 1), "i1");
        
        map.removeItem(i);
        assertFalse(map.containsItem(i));
        assertNotEquals(map.itemAtPos(1, 1), "NoItem"); // !! remove function of
        // VastMap is a function called by Character object in-game. it only removes
        // item from internal TreeMap!
    }
    
    @Test
    public void getItemFromString() {
        map.addItemToList(i, 0, 0);
        assertEquals(map.getItemFromName("i1"), i);
    }

}
