
public class SimpleHand extends Hand{

    public SimpleHand(Card c1, Card c2){
        super(c1, c2);
    }

    public boolean equals(SimpleHand h){
        Value thisV1, thisV2, hV1, hV2;
        thisV1 = this.c1.getValue();
        thisV2 = this.c2.getValue();
        hV1 = h.c1.getValue();
        hV2 = h.c2.getValue();

        // Check if card values are the same
        if(thisV1.equals(hV1) && thisV2.equals(hV2)){
            if(thisV1.equals(thisV2)){
                // pocket pair
                return true;
            }else{
                // different cards, compare suitedness
                boolean thisSuited, hSuited;
                thisSuited = this.c1.getSuit().equals(this.c2.getSuit());
                hSuited = h.c1.getSuit().equals(h.c2.getSuit());
                return thisSuited == hSuited;
            }
        }

        return false;
    }

    public String toString(){
        Value v1 = this.c1.getValue();
        Value v2 = this.c2.getValue();

        String str = v1.toString() + v2.toString();

        // if cards are different, add offsuit/suited
        if(!v1.equals(v2)){
            if(this.c1.getSuit().equals(this.c2.getSuit())){
                str += "s";
            }else{
                str += "o";
            }
        }

        return str;
    }
}
