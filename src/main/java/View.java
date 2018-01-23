import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Iterator;

public class View{

    private final Logger log = LoggerFactory.getLogger(View.class);
    private MVC mvc;
    private AppFrame frame;

    public View(MVC mvc){
        this.mvc = mvc;
        this.frame = new AppFrame();
        log.debug("View constructed");
    }

    public void init(){
        switchToSimpleRange();
        this.frame.setVisible(true);
        log.debug("View initialized");
    }

    public void notifyModelChanged(){
        log.info("Updating view");
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
