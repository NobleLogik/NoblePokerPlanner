import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest{

    @Test
    public void toString_sample(){
        assertEquals("Ac", Card.ACE_CLUB.toString());
    }
}
