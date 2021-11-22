package pesten;

public class PestenCard {
    
    private Card card;

    public PestenCard(Card card) {
        this.card = card;
    }

    public void onDraw(Pesten game) {
        game.drawCard();
        game.nextPlayer();
    }

    public boolean onCheck(Pesten game, PestenCard playedCard) {
        return Card.compareCards(this.card, playedCard.card);
    }

    public void onNext(Pesten game) {
        game.nextPlayer();
    }

    public String toString() {
        return card.toString();
    }

    public Card getCard() {
        return card;
    }

}
