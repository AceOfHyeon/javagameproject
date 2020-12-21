

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class GameModelTest {
    
    private Character mc;
    private VastMap map;
    private Storage s;
    
    @BeforeEach
    public void setup() {
        mc = new Character();
        map = new VastMap();
        s = new Storage(map);
    }
    
    @Test
    public void takeItemTest1() {
        map.characterIsAt(1, 1, mc);
        assertTrue(mc.containsItem(s.getFF().getItemName())); // mc now possesses item
        assertFalse(map.containsItem(s.getFF())); // map doesn't have it
    }
    
    @Test
    public void takeItemTest2() { 
        /* now, actually move character using methods and
         * test if map successfully updates!
         */
        mc.moveS();
        mc.moveE();
        mc.moveE();
        mc.moveE();
        
        map.characterIsAt(mc.getPositionX(), mc.getPositionY(), mc);
        
        assertTrue(mc.containsItem(s.getRB().getItemName()));
        // characterisAt correctly moves ONLY the item at new character position
        assertFalse(mc.containsItem(s.getBM().getItemName())); 
        assertFalse(map.containsItem(s.getRB()));
    }
    
    @Test
    public void testStatDisplay() { // simple character state test
        mc.addElementalism(2);
        mc.addKnowledge(5);
        assertEquals(mc.displayStats(), "Knowledge: " + 15 + "  | Elementalism: " + 12);
    }
    
    @Test
    public void numberOfRemainingMapItems() {
        assertEquals(map.numberOfRemainingItems(), 3);
        map.characterIsAt(4, 2, mc);
        assertEquals(map.numberOfRemainingItems(), 2);
    }
    
    // call save file files/saves/forTesting.txt, which is a save where character has 2/3 items
    @Test
    public void testSave() {
        mc.loadSaveFile(map, "files/saves/forTesting.txt");
        assertEquals(map.numberOfRemainingItems(), 1);
        assertTrue(map.containsItem(s.getRB())); // RB is only item remaining
        assertTrue(mc.containsItem(s.getFF().getItemName()) 
                && mc.containsItem(s.getBM().getItemName()));
        assertEquals(mc.getCharacterElement(), "Water"); // correctly loads element type
        assertEquals(mc.getCharacterName(), "Elemental");
    }

}
