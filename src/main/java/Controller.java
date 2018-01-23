import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Controller{

    private final Logger log = LoggerFactory.getLogger(Controller.class);
    private MVC mvc;

    public Controller(MVC mvc){
        this.mvc = mvc;
        log.debug("Controller initialized");
    }

    public void clickOnSimpleHand(SimpleHand h){
        log.info("Received click on hand {}", h.toString());
        this.mvc.getModel().addOrRemoveSimpleHand(h);
    }

}
