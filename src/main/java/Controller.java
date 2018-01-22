public class Controller{

    private MVC mvc;

    public Controller(MVC mvc){
        this.mvc = mvc;
    }

    public void clickOnSimpleHand(SimpleHand h){
        this.mvc.getModel().addOrRemoveSimpleHand(h);
    }

}
