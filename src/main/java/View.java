import javax.swing.JFrame;

public class View{

    private MVC mvc;
    private AppFrame frame;

    public View(MVC mvc){
        this.mvc = mvc;
        this.frame = new AppFrame();
    }

    public void init(){
        switchToSimpleRange();
        this.frame.setVisible(true);
    }

    public void notifyModelChanged(){
        switchToSimpleRange();
    }

    private void switchToSimpleRange(){
        SimpleRange r = this.mvc.getModel().getSimpleRange();
        this.frame.setContentPane(new SimpleRangeMatrix(r));
    }

}
