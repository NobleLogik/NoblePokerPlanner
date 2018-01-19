import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.FontMetrics;

public class MatrixButton extends JPanel{

    private SimpleHand hand;

    public MatrixButton(SimpleHand hand){
        super();
        this.hand = hand;
    }

    protected void paintComponent(Graphics g){
        // draw contour
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1); // -1 necessary to stay inbounds

        // draw text
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
}
