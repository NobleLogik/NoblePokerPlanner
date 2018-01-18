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

    public int size(){
        int size = 0;
        for(SimpleHand h : this.range){
            switch(h.getSuitedness()){
            case POCKET:
                size += 6;
                break;
            case SUITED:
                size += 4;
                break;
            case OFFSUIT:
                size += 12;
                break;
            }
        }
        return size;
    }
}
