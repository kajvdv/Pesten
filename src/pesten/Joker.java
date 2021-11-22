package pesten;

public class Joker extends Card {
    
    public Joker() {
        super(Suit.EMPTY, Value.EMPTY);
    }

    @Override
    public boolean isSameNumber(Card card) {
        return true;
    }

    @Override
    public boolean isSameSuit(Card card) {
        return true;
    }

    @Override
    public String toString() {
        return "Joker";
    }

}