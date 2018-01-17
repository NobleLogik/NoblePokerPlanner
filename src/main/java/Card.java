public enum Card{

    TWO_CLUB(Value.TWO, Suit.CLUB),
    THREE_CLUB(Value.THREE, Suit.CLUB),
    FOUR_CLUB(Value.FOUR, Suit.CLUB),
    FIVE_CLUB(Value.FIVE, Suit.CLUB),
    SIX_CLUB(Value.SIX, Suit.CLUB),
    SEVEN_CLUB(Value.SEVEN, Suit.CLUB),
    EIGHT_CLUB(Value.EIGHT, Suit.CLUB),
    NINE_CLUB(Value.NINE, Suit.CLUB),
    TEN_CLUB(Value.TEN, Suit.CLUB),
    JACK_CLUB(Value.JACK, Suit.CLUB),
    QUEEN_CLUB(Value.QUEEN, Suit.CLUB),
    KING_CLUB(Value.KING, Suit.CLUB),
    ACE_CLUB(Value.ACE, Suit.CLUB),
    TWO_DIAMOND(Value.TWO, Suit.DIAMOND),
    THREE_DIAMOND(Value.THREE, Suit.DIAMOND),
    FOUR_DIAMOND(Value.FOUR, Suit.DIAMOND),
    FIVE_DIAMOND(Value.FIVE, Suit.DIAMOND),
    SIX_DIAMOND(Value.SIX, Suit.DIAMOND),
    SEVEN_DIAMOND(Value.SEVEN, Suit.DIAMOND),
    EIGHT_DIAMOND(Value.EIGHT, Suit.DIAMOND),
    NINE_DIAMOND(Value.NINE, Suit.DIAMOND),
    TEN_DIAMOND(Value.TEN, Suit.DIAMOND),
    JACK_DIAMOND(Value.JACK, Suit.DIAMOND),
    QUEEN_DIAMOND(Value.QUEEN, Suit.DIAMOND),
    KING_DIAMOND(Value.KING, Suit.DIAMOND),
    ACE_DIAMOND(Value.ACE, Suit.DIAMOND),
    TWO_HEART(Value.TWO, Suit.HEART),
    THREE_HEART(Value.THREE, Suit.HEART),
    FOUR_HEART(Value.FOUR, Suit.HEART),
    FIVE_HEART(Value.FIVE, Suit.HEART),
    SIX_HEART(Value.SIX, Suit.HEART),
    SEVEN_HEART(Value.SEVEN, Suit.HEART),
    EIGHT_HEART(Value.EIGHT, Suit.HEART),
    NINE_HEART(Value.NINE, Suit.HEART),
    TEN_HEART(Value.TEN, Suit.HEART),
    JACK_HEART(Value.JACK, Suit.HEART),
    QUEEN_HEART(Value.QUEEN, Suit.HEART),
    KING_HEART(Value.KING, Suit.HEART),
    ACE_HEART(Value.ACE, Suit.HEART),
    TWO_SPADE(Value.TWO, Suit.SPADE),
    THREE_SPADE(Value.THREE, Suit.SPADE),
    FOUR_SPADE(Value.FOUR, Suit.SPADE),
    FIVE_SPADE(Value.FIVE, Suit.SPADE),
    SIX_SPADE(Value.SIX, Suit.SPADE),
    SEVEN_SPADE(Value.SEVEN, Suit.SPADE),
    EIGHT_SPADE(Value.EIGHT, Suit.SPADE),
    NINE_SPADE(Value.NINE, Suit.SPADE),
    TEN_SPADE(Value.TEN, Suit.SPADE),
    JACK_SPADE(Value.JACK, Suit.SPADE),
    QUEEN_SPADE(Value.QUEEN, Suit.SPADE),
    KING_SPADE(Value.KING, Suit.SPADE),
    ACE_SPADE(Value.ACE, Suit.SPADE);

    private Value value;
    private Suit suit;

    Card(Value value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public Value getValue(){
        return this.value;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public String toString(){
        return this.value.toString() + this.suit.toString();
    }

    private enum Value{
        TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'), TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');

        private char c;

        Value(char c){
            this.c = c;
        }

        public String toString(){
            return "" + this.c;
        }
    }

    private enum Suit{
        CLUB('c'), DIAMOND('d'), HEART('h'), SPADE('s');

        private char c;

        Suit(char c){
            this.c = c;
        }

        public String toString(){
            return "" + this.c;
        }
    }
}

