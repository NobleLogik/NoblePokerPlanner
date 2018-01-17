
public class SimpleHand extends Hand{

    public SimpleHand(Card c1, Card c2){
        super(c1, c2);
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
