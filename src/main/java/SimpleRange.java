import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.HashSet;
import java.util.Iterator;

import java.lang.IllegalStateException;

public class SimpleRange{

    private final Logger log = LoggerFactory.getLogger(SimpleRange.class);
    private HashSet<SimpleHand> range;

    public SimpleRange(){
        this.range = new HashSet<SimpleHand>();
    }

    public void add(SimpleHand h){
        if(this.contains(h)){
            log.error("Trying to hand {} when it's already in the range", h.toString());
            throw new IllegalStateException("Cannot add " + h.toString() + "because it is already in the SimpleRange");
        }
        this.range.add(h);
        log.debug("Added hand {}", h.toString());
    }

    public void remove(SimpleHand h){
        this.range.remove(getObjectReference(h));
        log.debug("Removed hand {}", h.toString());
    }

    public boolean contains(SimpleHand h){
        Iterator<SimpleHand> it = this.range.iterator();
        while(it.hasNext()){
            if(h.equals(it.next())){
                log.trace("Hand {} is contained in the range", h.toString());
                return true;
            }
        }

        log.trace("Hand {} is not contained in the range", h.toString());
        return false; // no match found
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
        log.trace("The range contains {} combos", size);
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

    private SimpleHand getObjectReference(SimpleHand h){
        Iterator<SimpleHand> it = this.range.iterator();
        while(it.hasNext()){
            SimpleHand ref = it.next();
            if(h.equals(ref)) return ref;
        }

        log.error("Trying to remove hand {} but it's not in the range", h.toString());
        throw new IllegalStateException("Cannot retrieve SimpleHand reference for hand " + h.toString() + "because it is not in the range");
    }
}
