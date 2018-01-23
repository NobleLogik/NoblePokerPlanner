import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class ControllerTest{

    private MVC mvc;
    private Model model;

    @Test
    public void clickOnSimpleHand_actOnModel(){
        setupMocks();
        Controller control = new Controller(this.mvc);
        SimpleHand h = new SimpleHand(Value.FIVE, Value.THREE, true);

        control.clickOnSimpleHand(h);
        verify(this.model).addOrRemoveSimpleHand(h);
    }

    private void setupMocks(){
        this.mvc = mock(MVC.class);
        this.model = mock(Model.class);

        when(this.mvc.getModel()).thenReturn(this.model);
    }
}
