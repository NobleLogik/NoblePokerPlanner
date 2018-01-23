import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class ModelTest{

    private MVC mvc;
    private View view;

    @Test
    public void addOrRemoveSimpleHand_logic(){
        setupMocks();
        Model model = new Model(this.mvc);
        SimpleHand h = new SimpleHand(Value.FIVE, Value.THREE, true);

        assumeFalse(model.getSimpleRange().contains(h));
        model.addOrRemoveSimpleHand(h);
        assertTrue(model.getSimpleRange().contains(h));
        model.addOrRemoveSimpleHand(h);
        assertFalse(model.getSimpleRange().contains(h));
    }

    @Test
    public void addOrRemoveSimpleHand_notifyView(){
        setupMocks();
        Model model = new Model(this.mvc);
        SimpleHand h = new SimpleHand(Value.FIVE, Value.THREE, true);

        model.addOrRemoveSimpleHand(h);
        model.addOrRemoveSimpleHand(h);
        verify(this.view, times(2)).notifyModelChanged();
    }

    private void setupMocks(){
        this.mvc = mock(MVC.class);
        this.view = mock(View.class);

        when(this.mvc.getView()).thenReturn(this.view);
    }
}
