import java.lang.IllegalArgumentException;

public class Hand{

    protected Card c1, c2;

    public Hand(Card c1, Card c2){
        if(c1.equals(c2)) throw new IllegalArgumentException("Hand cannot be constructed with two of the same card");

        // place cards in descending order
        Value v1 = c1.getValue();
        Value v2 = c2.getValue();
        boolean cond1 = v1.compareTo(v2) < 0; // c2 has higher value than c1
        boolean cond2 = v1.equals(v2) && c1.getSuit().compareTo(c2.getSuit()) < 0; // same value, but c2 has "higher" suit than c1
        if(cond1 || cond2){
            this.c1 = c2;
            this.c2 = c1;
        }else{
            this.c1 = c1;
            this.c2 = c2;
        }
    }

    public String toString(){
        return this.c1.toString() + this.c2.toString();
    }
}
