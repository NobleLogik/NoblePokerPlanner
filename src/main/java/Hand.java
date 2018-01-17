public class Hand{

    private Card c1, c2;

    public Hand(Card c1, Card c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    public String toString(){
        Value v1 = this.c1.getValue();
        Value v2 = this.c2.getValue();

        // highest card first
        if(v1.compareTo(v2) < 0){
            Value tmp = v1;
            v1 = v2;
            v2 = tmp;
        }

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
