import java.lang.IllegalArgumentException;

import java.util.Optional;

public class SimpleHand{

    public enum Suitedness {POCKET, OFFSUIT, SUITED;}
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
            if(suited.isPresent()) throw new IllegalArgumentException("A SimpleHand with two identical values (pocket pair) cannot have a suitedness");
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
            if(!suited.isPresent()) throw new IllegalArgumentException("A SimpleHand with two different values must have a suitedness");
            if(suited.get()){
                this.suited = Suitedness.SUITED;
            }else{
                this.suited = Suitedness.OFFSUIT;
            }
        }
    }

    public Suitedness getSuitedness(){
        return this.suited;
    }

    public boolean equals(SimpleHand h){
        return this.v1.equals(h.v1) && this.v2.equals(h.v2) && this.suited.equals(h.suited);
    }

    public String toString(){
        String str = this.v1.toString() + this.v2.toString();
        if(this.suited.equals(Suitedness.SUITED)) str += "s";
        if(this.suited.equals(Suitedness.OFFSUIT)) str += "o";
        return str;
    }
}
