import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.IllegalArgumentException;

public class HandTest {

    @Test
    public void constructor_identicalCards(){
        assertThrows(IllegalArgumentException.class, () -> {new Hand(Card.ACE_CLUB, Card.ACE_CLUB);});
    }

    @Test
    public void toString_sample(){
        Hand h = new Hand(Card.SIX_HEART, Card.FOUR_SPADE);
        assertEquals("6h4s", h.toString());
    }

    @Test
    public void toString_highestFirst(){
        Hand h = new Hand(Card.TWO_CLUB, Card.ACE_DIAMOND);
        assertEquals("Ad2c", h.toString());
    }

    @Test
    public void toString_orderSuitIfSameValue(){
        Hand h = new Hand(Card.ACE_SPADE, Card.ACE_CLUB);
        assertEquals("AcAs", h.toString());
    }
}
