package pesten;

public class Card {

    private Suit suit;
    private Value number;

    public Card(Suit suit, Value number) {
        this.suit = suit;
        this.number = number;
    }

    public boolean isSameSuit(Card card) {
        return this.suit == card.suit;
    }

    public boolean isSameNumber(Card card) {
        return this.number == card.number;
    }

    public static boolean compareCards(Card card1, Card card2) {
        return card1.isSameNumber(card2) || card2.isSameNumber(card1) ||
        card1.isSameSuit(card2) || card2.isSameSuit(card1);
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return number;
    }

    @Override
    public String toString() {
        return suit.toString() + " " + number.toString();
    }
}