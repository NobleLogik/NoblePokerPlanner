import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AppFrame extends JFrame{

    final String DEV_NAME = "NobleLogik";
    final String VERSION = "0.1.0";

    public AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,1200,900);
        this.setTitle("PokerPlanner");
        this.setJMenuBar(genMenuBar());
    }

    private JMenuBar genMenuBar(){
        JMenuBar bar = new JMenuBar();
        bar.add(genAboutMenu());
        return bar;
    }

    private JMenu genAboutMenu(){
        JMenu menu = new JMenu("About");
        JMenuItem name = new JMenuItem("By " + this.DEV_NAME);
        name.setEnabled(false);
        JMenuItem version = new JMenuItem("ver. " + this.VERSION);
        version.setEnabled(false);

        menu.add(name);
        menu.add(version);
        return menu;
    }
}
