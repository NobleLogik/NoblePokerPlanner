import java.util.HashSet;
import java.util.Iterator;

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

    public Iterator<SimpleHand> iterator(){
        return this.range.iterator();
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

    public static SimpleRange genFullRange(){
        SimpleRange r = new SimpleRange();
        for(Value v1 : Value.values()){
            for(Value v2 : Value.values()){
                if(v1.compareTo(v2) >= 0){
                    if(v1.equals(v2)){
                        SimpleHand h = new SimpleHand(v1, v2);
                        r.add(h);
                    }else{
                        SimpleHand h1 = new SimpleHand(v1, v2, false);
                        SimpleHand h2 = new SimpleHand(v1, v2, true);
                        r.add(h1);
                        r.add(h2);
                    }
                }
            }
        }
        return r;
    }
}
