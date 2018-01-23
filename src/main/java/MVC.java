import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class MVC{

    private final Logger log = LoggerFactory.getLogger(MVC.class);
    private Model model;
    private View view;
    private Controller controller;

    public MVC(){
        this.model = new Model(this);
        this.view = new View(this);
        this.controller = new Controller(this);
        this.view.init();
    }

    public Model getModel(){
        log.trace("Model accessed");
        return this.model;
    }

    public View getView(){
        log.trace("View accessed");
        return this.view;
    }

    public Controller getController(){
        log.trace("Controller accessed");
        return this.controller;
    }
}
