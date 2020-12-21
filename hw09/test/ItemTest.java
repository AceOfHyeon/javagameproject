

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item i;
    
    @BeforeEach
    public void setup() {
        i = new Item("Tester", "This is a test", "files/test");
    }
    
    @Test
    public void itemCreationTest() {
        assertEquals(i.getDescription(), "This is a test");
        assertEquals(i.getImageLink(), "files/test");
        assertEquals(i.getItemName(), "Tester");
    }

}
