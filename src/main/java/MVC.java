
public class MVC{

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
        return this.model;
    }

    public View getView(){
        return this.view;
    }

    public Controller getController(){
        return this.controller;
    }
}
