import javax.swing.JFrame;

public class View{

    private MVC mvc;
    private AppFrame frame;

    public View(MVC mvc){
        this.mvc = mvc;
        this.frame = new AppFrame();
        switchToSimpleRange();
        this.frame.setVisible(true);
    }

    private void switchToSimpleRange(){
        this.frame.setContentPane(new SimpleRangeMatrix());
    }

}
