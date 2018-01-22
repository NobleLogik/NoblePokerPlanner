import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;

import java.util.HashMap;
import java.util.Iterator;

public class SimpleRangeMatrix extends JPanel{

    private HashMap<SimpleHand, MatrixButton> buttonMap;
    private SimpleRange range;

    public SimpleRangeMatrix(Controller control, SimpleRange range){
        super();
        this.range = range;
        this.buttonMap = genButtonMap(control);

        placeButtons();
    }

    private void placeButtons(){
        final int GRID_SIZE = 13; // This matrix should always be 13x13
        this.setLayout(new GridBagLayout());

        // Prepare common constraints
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.insets = new Insets(3, 3, 3, 3);
        c.anchor = GridBagConstraints.CENTER;

        // Place each buttons
        for(SimpleHand h : this.buttonMap.keySet()){
            Value[] val = h.getValues();
            c.gridx = GRID_SIZE - val[0].ordinal();
            c.gridy = GRID_SIZE - val[1].ordinal();

            // Reverse row/col for suited hands
            if(h.getSuitedness().equals(SimpleHand.Suitedness.SUITED)){
                int tmp = c.gridx;
                c.gridx = c.gridy;
                c.gridy = tmp;
            }

            MatrixButton b = this.buttonMap.get(h);
            this.add(b, c);
        }
    }

    private HashMap<SimpleHand, MatrixButton> genButtonMap(Controller control){
        HashMap<SimpleHand, MatrixButton> map = new HashMap<SimpleHand, MatrixButton>();

        Iterator<SimpleHand> it = SimpleRange.genFullRange().iterator();
        while(it.hasNext()){
            SimpleHand h = it.next();
            MatrixButton b = new MatrixButton(control, h);
            b.setActive(this.range.contains(h));
            map.put(h, b);
        }

        return map;
    }
}
