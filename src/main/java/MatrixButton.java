import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.FontMetrics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MatrixButton extends JPanel{

    private final Color OFF = Color.GRAY;
    private final Color ON = Color.RED;
    private SimpleHand hand;
    private Controller control;
    private boolean active;

    public MatrixButton(Controller control, SimpleHand hand){
        super();
        this.control = control;
        this.hand = hand;
        this.active = false;
        this.addMouseListener(new MatrixButtonListener());
    }

    public void setActive(boolean active){
        this.active = active;
    }

    protected void paintComponent(Graphics g){
        // draw contour
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1); // -1 necessary to stay inbounds

        // fill color
        if(active){
            g.setColor(ON);
        }else{
            g.setColor(OFF);
        }
        g.fillRect(1, 1, this.getWidth()-2, this.getHeight()-2); // -2 necessary to not fill over contour

        // draw text
        g.setColor(Color.BLACK);
        int[] coord = findCoordToCenterText(g);
        g.drawString(hand.toString(), coord[0], coord[1]);
    }

    private int[] findCoordToCenterText(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        FontMetrics fm = g2d.getFontMetrics();

        int[] coord = new int[2];
        coord[0] = (this.getWidth() - fm.stringWidth(hand.toString()))/2;
        coord[1] = (this.getHeight() - fm.getHeight())/2 + fm.getAscent();
        return coord;
    }

    private class MatrixButtonListener extends MouseAdapter{

        public MatrixButtonListener(){
            super();
        }

        public void mouseClicked(MouseEvent e){
            MatrixButton.this.control.clickOnSimpleHand(MatrixButton.this.hand);
        }
    }
}
