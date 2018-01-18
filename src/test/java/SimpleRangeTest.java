import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class SimpleRangeTest{

    @Test
    public void add_sample(){
        SimpleHand h = new SimpleHand(Value.QUEEN, Value.FIVE, true);
        SimpleRange r = new SimpleRange();

        assumeFalse(r.contains(h));
        r.add(h);
        assertTrue(r.contains(h));
    }

    @Test
    public void add_alreadyContained(){
        SimpleHand h = new SimpleHand(Value.QUEEN, Value.FIVE, true);
        SimpleRange r = new SimpleRange();

        r.add(h);
        assumeTrue(r.contains(h));
        r.add(h);
        assertTrue(r.contains(h));
    }

    @Test
    public void remove_sample(){
        SimpleHand h = new SimpleHand(Value.QUEEN, Value.FIVE, true);
        SimpleRange r = new SimpleRange();

        r.add(h);
        assumeTrue(r.contains(h));
        r.remove(h);
        assertFalse(r.contains(h));
    }

    @Test
    public void remove_alreadyNotContained(){
        SimpleHand h = new SimpleHand(Value.QUEEN, Value.FIVE, true);
        SimpleRange r = new SimpleRange();

        assumeFalse(r.contains(h));
        r.remove(h);
        assertFalse(r.contains(h));
    }

    @Test
    public void contains_logic(){
        SimpleHand h = new SimpleHand(Value.QUEEN, Value.FIVE, true);
        SimpleRange r = new SimpleRange();

        assertFalse(r.contains(h));
        r.add(h);
        assertTrue(r.contains(h));
        r.remove(h);
        assertFalse(r.contains(h));
    }

    @Test
    public void size_pocket(){
        SimpleHand h = new SimpleHand(Value.ACE, Value.ACE);
        SimpleRange r = new SimpleRange();

        r.add(h);
        assertEquals(6, r.size());
    }

    @Test
    public void size_offsuit(){
        SimpleHand h = new SimpleHand(Value.ACE, Value.THREE, false);
        SimpleRange r = new SimpleRange();

        r.add(h);
        assertEquals(12, r.size());
    }

    @Test
    public void size_suited(){
        SimpleHand h = new SimpleHand(Value.ACE, Value.THREE, true);
        SimpleRange r = new SimpleRange();

        r.add(h);
        assertEquals(4, r.size());
    }

    @Test
    public void size_sum(){
        SimpleHand h1 = new SimpleHand(Value.ACE, Value.ACE);
        SimpleHand h2 = new SimpleHand(Value.ACE, Value.THREE, false);
        SimpleHand h3 = new SimpleHand(Value.ACE, Value.THREE, true);
        SimpleRange r = new SimpleRange();

        r.add(h1);
        r.add(h2);
        r.add(h3);
        assertEquals(22, r.size());
    }

    @Test
    public void genFullRange_size(){
        assertEquals(1326, SimpleRange.genFullRange().size());
    }
}
