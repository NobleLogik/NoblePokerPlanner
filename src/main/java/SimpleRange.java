import java.util.HashSet;

public class SimpleRange{

    private HashSet<SimpleHand> range;

    public SimpleRange(){
        this.range = new HashSet<SimpleHand>();
    }

    public void add(SimpleHand h){
        this.range.add(h);
    }

    public void remove(SimpleHand h){
        this.range.remove(h);
    }

    public boolean contains(SimpleHand h){
        return this.range.contains(h);
    }
}
