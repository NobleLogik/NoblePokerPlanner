public enum Suit{
    SPADE('s'), HEART('h'), DIAMOND('d'), CLUB('c');

    private char c;

    Suit(char c){
        this.c = c;
    }

    public String toString(){
        return "" + this.c;
    }
}
