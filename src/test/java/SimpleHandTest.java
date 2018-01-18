import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.IllegalArgumentException;

public class SimpleHandTest{

    @Test
    public void constructor_illegalArgs(){
        assertThrows(IllegalArgumentException.class, () -> {new SimpleHand(Value.ACE, Value.ACE, true);});
        assertThrows(IllegalArgumentException.class, () -> {new SimpleHand(Value.ACE, Value.TWO);});
    }

    @Test
    public void equals_value(){
        SimpleHand h1 = new SimpleHand(Value.ACE, Value.TEN, true);
        SimpleHand h2 = new SimpleHand(Value.ACE, Value.QUEEN, true);
        SimpleHand h3 = new SimpleHand(Value.KING, Value.TEN, true);

        assertTrue(h1.equals(h1));
        assertFalse(h1.equals(h2));
        assertFalse(h1.equals(h3));
    }

    @Test
    public void equals_suitedness(){
        SimpleHand h1 = new SimpleHand(Value.ACE, Value.TEN, true);
        SimpleHand h2 = new SimpleHand(Value.ACE, Value.TEN, false);

        assertTrue(h1.equals(h1));
        assertFalse(h1.equals(h2));
    }

    @Test void getValues_sample(){
        SimpleHand h = new SimpleHand(Value.QUEEN, Value.FIVE, false);

        assertEquals(Value.QUEEN, h.getValues()[0]);
        assertEquals(Value.FIVE, h.getValues()[1]);
    }

    @Test void getValues_highestFirst(){
        SimpleHand h = new SimpleHand(Value.FIVE, Value.QUEEN, false);

        assertEquals(Value.QUEEN, h.getValues()[0]);
        assertEquals(Value.FIVE, h.getValues()[1]);
    }

    @Test
    public void equals_pairVsNonPair(){
        SimpleHand h1 = new SimpleHand(Value.ACE, Value.ACE);
        SimpleHand h2 = new SimpleHand(Value.KING, Value.TEN, false);

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
}
