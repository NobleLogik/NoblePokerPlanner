import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class SimpleRangeTest{

    @Test
    public void add_sample(){
        SimpleHand h = new SimpleHand(Card.JACK_HEART, Card.EIGHT_HEART);
        SimpleRange r = new SimpleRange();

        assumeFalse(r.contains(h));
        r.add(h);
        assertTrue(r.contains(h));
    }

    @Test
    public void add_alreadyContained(){
        SimpleHand h = new SimpleHand(Card.JACK_HEART, Card.EIGHT_HEART);
        SimpleRange r = new SimpleRange();

        r.add(h);
        assumeTrue(r.contains(h));
        r.add(h);
        assertTrue(r.contains(h));
    }

    @Test
    public void remove_sample(){
        SimpleHand h = new SimpleHand(Card.JACK_HEART, Card.EIGHT_HEART);
        SimpleRange r = new SimpleRange();

        r.add(h);
        assumeTrue(r.contains(h));
        r.remove(h);
        assertFalse(r.contains(h));
    }

    @Test
    public void remove_alreadyNotContained(){
        SimpleHand h = new SimpleHand(Card.JACK_HEART, Card.EIGHT_HEART);
        SimpleRange r = new SimpleRange();

        assumeFalse(r.contains(h));
        r.remove(h);
        assertFalse(r.contains(h));
    }

    @Test
    public void contains_logic(){
        SimpleHand h = new SimpleHand(Card.JACK_HEART, Card.EIGHT_HEART);
        SimpleRange r = new SimpleRange();

        assertFalse(r.contains(h));
        r.add(h);
        assertTrue(r.contains(h));
        r.remove(h);
        assertFalse(r.contains(h));
    }

}
