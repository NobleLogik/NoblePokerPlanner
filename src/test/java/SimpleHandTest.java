import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleHandTest{

    @Test
    public void toString_offsuit(){
        SimpleHand h = new SimpleHand(Card.QUEEN_DIAMOND, Card.FIVE_HEART);
        assertEquals(h.toString(), "Q5o");
    }

    @Test
    public void toString_suited(){
        SimpleHand h = new SimpleHand(Card.TEN_CLUB, Card.TWO_CLUB);
        assertEquals(h.toString(), "T2s");
    }

    @Test
    public void toString_pocket(){
        SimpleHand h = new SimpleHand(Card.THREE_SPADE, Card.THREE_CLUB);
        assertEquals(h.toString(), "33");
    }

    @Test
    public void toString_highestFirst(){
        SimpleHand h = new SimpleHand(Card.TWO_CLUB, Card.ACE_DIAMOND);
        assertEquals(h.toString(), "A2o");
    }
}
