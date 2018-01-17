import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleHandTest{

    @Test
    public void toString_offsuit(){
        SimpleHand h = new SimpleHand(Card.QUEEN_DIAMOND, Card.FIVE_HEART);
        assertEquals("Q5o", h.toString());
    }

    @Test
    public void toString_suited(){
        SimpleHand h = new SimpleHand(Card.TEN_CLUB, Card.TWO_CLUB);
        assertEquals("T2s", h.toString());
    }

    @Test
    public void toString_pocket(){
        SimpleHand h = new SimpleHand(Card.THREE_SPADE, Card.THREE_CLUB);
        assertEquals("33", h.toString());
    }

    @Test
    public void toString_highestFirst(){
        SimpleHand h = new SimpleHand(Card.TWO_CLUB, Card.ACE_DIAMOND);
        assertEquals("A2o", h.toString());
    }
}
