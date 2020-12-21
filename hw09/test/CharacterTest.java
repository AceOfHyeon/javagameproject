

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CharacterTest {
    private Character c;
    
    @BeforeEach
    public void setup() {
        c = new Character();
    }
    
    @Test
    public void testChangeName() {
        c.changeName("Test Name");
        assertEquals(c.getCharacterName(), "Test Name");
        c.changeName("Test!% Name2");
        assertEquals(c.getCharacterName(), "Test% Name2");
        /* ! is the only illegal character, since it is the point of dividing a save file.
         * all other characters are legal
         */
        c.changeName("");
        assertEquals(c.getCharacterName(), "Elemental");
        /* this test does nothing because "" is an empty string, and the character changeName
         * function retains the original name ("Elemental") in this case.
         */
    }
    
    @Test
    public void testChangeElement() {
        c.changeElement("Shadow");
        assertEquals(c.getCharacterElement(), "Shadow");
        /* player will only be able to choose between 5 different elements, no need to test 
         * other strings
         */
        assertEquals(c.getCharIconLink(), "files/character/Shadow.png");
    }
    
    @Test
    public void directionalMovement() {
        // initial position: [0][0] on a 5 by 5 grid
        c.moveE(); // Moves character right in Y direction
        c.moveN(); // Moves character up in X direction
        int x = c.getPositionX(); // X is vertical direction
        int y = c.getPositionY(); // Y is horizontal direction
        assertEquals(c.getPositionX(), 0); // because character cannot go off of the grid.
        assertEquals(c.getPositionY(), 1); // moving east is valid
        c.moveE();
        c.moveE();
        c.moveE();
        c.moveE(); // does not move any further, since grid edge is at index 4
        c.moveS();
        c.moveS();
        c.moveN();
        x = c.getPositionX();
        y = c.getPositionY();
        assertEquals(x, 1);
        assertEquals(y, 4);
        c.moveW();
        c.moveW();
        c.moveW();
        c.moveW(); // stops here
        c.moveW();
        assertEquals(c.getPositionY(), 0);
        c.moveS();
        c.moveS();
        c.moveS(); // stop here
        c.moveS();
        x = c.getPositionX();
        assertEquals(x, 4);
        // checked all boundaries, finish test.
    }
    
    
    // check change element and getCharIconLink
    @Test
    public void itemlinktest() {
        assertEquals(c.getCharIconLink(), "files/character/Neutral.png");
        c.changeElement("Shadow");
        assertEquals(c.getCharIconLink(), "files/character/Shadow.png");
    }
    
}
