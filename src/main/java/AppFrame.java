import javax.swing.JFrame;

public class AppFrame extends JFrame{

    public AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,1200,900);
        this.setContentPane(new SimpleRangeMatrix());
        this.setTitle("PokerPlanner");
        this.setVisible(true);
    }
}
