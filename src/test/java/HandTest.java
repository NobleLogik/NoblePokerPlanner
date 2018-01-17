import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.IllegalArgumentException;

public class HandTest {

    @Test
    public void constructor_identicalCards(){
        assertThrows(IllegalArgumentException.class, () -> {new Hand(Card.ACE_CLUB, Card.ACE_CLUB);});
    }

    @Test
    public void toString_offsuit(){
        Hand h = new Hand(Card.QUEEN_DIAMOND, Card.FIVE_HEART);
        assertEquals(h.toString(), "Q5o");
    }

    @Test
    public void toString_suited(){
        Hand h = new Hand(Card.TEN_CLUB, Card.TWO_CLUB);
        assertEquals(h.toString(), "T2s");
    }

    @Test
    public void toString_pocket(){
        Hand h = new Hand(Card.THREE_SPADE, Card.THREE_CLUB);
        assertEquals(h.toString(), "33");
    }

    @Test
    public void toString_highestFirst(){
        Hand h = new Hand(Card.TWO_CLUB, Card.ACE_DIAMOND);
        assertEquals(h.toString(), "A2o");
    }
}
