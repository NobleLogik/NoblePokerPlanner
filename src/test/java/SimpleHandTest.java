import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleHandTest{

    @Test
    public void equals_sample(){
        SimpleHand h1 = new SimpleHand(Value.ACE, Value.KING, false);
        SimpleHand h2 = new SimpleHand(Value.EIGHT, Value.FIVE, true);

        assertTrue(h1.equals(h1));
        assertFalse(h1.equals(h2));
    }

    @Test
    public void toString_offsuit(){
        SimpleHand h = new SimpleHand(Value.QUEEN, Value.FIVE, false);
        assertEquals("Q5o", h.toString());
    }

    @Test
    public void toString_suited(){
        SimpleHand h = new SimpleHand(Value.QUEEN, Value.FIVE, true);
        assertEquals("Q5s", h.toString());
    }

    @Test
    public void toString_pocket(){
        SimpleHand h = new SimpleHand(Value.THREE, Value.THREE);
        assertEquals("33", h.toString());
    }

    @Test
    public void toString_highestFirst(){
        SimpleHand h = new SimpleHand(Value.FIVE, Value.QUEEN, true);
        assertEquals("Q5s", h.toString());
    }
}
