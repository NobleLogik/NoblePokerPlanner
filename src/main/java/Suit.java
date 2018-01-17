public enum Suit{
    CLUB('c'), DIAMOND('d'), HEART('h'), SPADE('s');

    private char c;

    Suit(char c){
        this.c = c;
    }

    public String toString(){
        return "" + this.c;
    }
}
