import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.lang.IllegalArgumentException;

import java.util.Optional;

public class SimpleHand{

    public enum Suitedness {POCKET, OFFSUIT, SUITED;}
    private final Logger log = LoggerFactory.getLogger(SimpleHand.class);
    private Value v1, v2;
    private Suitedness suited;

    public SimpleHand(Value v1, Value v2, boolean suited){
        Optional<Boolean> bool = Optional.of(suited);
        buildSimpleHand(v1, v2, bool);
    }

    public SimpleHand(Value v1, Value v2){
        Optional<Boolean> bool = Optional.empty();
        buildSimpleHand(v1, v2, bool);
    }

    private void buildSimpleHand(Value v1, Value v2, Optional<Boolean> suited){
        if(v1.equals(v2)){
            // pocket pair
            this.v1 = v1;
            this.v2 = v2;
            if(suited.isPresent()){
                log.error("Received pocket pair ({},{}) with a suitedness ({})", v1.toString(), v2.toString(), suited.get().toString());
                throw new IllegalArgumentException("A SimpleHand with two identical values (pocket pair) cannot have a suitedness");
            }
            this.suited = Suitedness.POCKET;
        }else{
            // different cards
            // place values in descending order
            if(v1.compareTo(v2) < 0){
                this.v1 = v2;
                this.v2 = v1;
            }else{
                this.v1 = v1;
                this.v2 = v2;
            }

            // store suitedness
            if(!suited.isPresent()){
                log.error("Received different cards ({},{}) without a suitedness", v1.toString(), v2.toString());
                throw new IllegalArgumentException("A SimpleHand with two different values must have a suitedness");
            }
            if(suited.get()){
                this.suited = Suitedness.SUITED;
            }else{
                this.suited = Suitedness.OFFSUIT;
            }
        }

        log.trace("SimpleHand built with value ({},{}) and suitedness {}", this.v1.toString(), this.v2.toString(), this.suited.toString());
    }

    public Suitedness getSuitedness(){
        return this.suited;
    }

    public Value[] getValues(){
        Value[] v = new Value[2];
        v[0] = this.v1;
        v[1] = this.v2;
        return v;
    }

    public boolean equals(SimpleHand h){
        log.trace("Hand A: {}, {}, {}", this.v1.toString(), this.v2.toString(), this.suited.toString());
        log.trace("Hand B: {}, {}, {}", h.v1.toString(), h.v2.toString(), h.suited.toString());
        return this.v1.equals(h.v1) && this.v2.equals(h.v2) && this.suited.equals(h.suited);
    }

    public String toString(){
        String str = this.v1.toString() + this.v2.toString();
        if(this.suited.equals(Suitedness.SUITED)) str += "s";
        if(this.suited.equals(Suitedness.OFFSUIT)) str += "o";
        return str;
    }
}
