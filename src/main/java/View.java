import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Iterator;

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
        Controller c = this.mvc.getController();

        JPanel contentPane = (JPanel) this.frame.getContentPane();
        contentPane.removeAll();
        contentPane.add(new SimpleRangeMatrix(c, r));
        contentPane.revalidate();
        contentPane.repaint();
    }

}
