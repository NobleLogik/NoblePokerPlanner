import java.lang.IllegalArgumentException;

public class Hand{

    protected Card c1, c2;

    public Hand(Card c1, Card c2){
        if(c1.equals(c2)) throw new IllegalArgumentException("Hand cannot be constructed with two of the same card");

        // place cards in descending order
        Value v1 = c1.getValue();
        Value v2 = c2.getValue();
        if(v1.compareTo(v2) < 0){
            // v2 > v1,
            this.c1 = c2;
            this.c2 = c1;
        }else{
            // v1 >= v2
            this.c1 = c1;
            this.c2 = c2;
        }
    }

    public String toString(){
        return this.c1.toString() + this.c2.toString();
    }
}
