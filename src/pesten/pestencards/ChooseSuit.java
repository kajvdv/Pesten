package pesten.pestencards;

import pesten.*;

public class ChooseSuit extends PestenCard {

    private Suit choosenSuit = null;

    public ChooseSuit(Card card) {
        super(card);
    }

    @Override
    public boolean onCheck(Pesten game, PestenCard playedCard) {
        if (playedCard.getCard().isSameNumber(this.getCard()) ||
        playedCard.getCard().getSuit() == choosenSuit) {
            return true;
        }
        else {
            game.getInterface().printMessage("Choosen suit is: " + choosenSuit.toString() + ". ");
            return false;
        }
    }

    @Override
    public void onNext(Pesten game) {
        if (choosenSuit == null) {
            PestenInterface user = game.getInterface();
            choosenSuit = user.getSuitChoose();
        }
        game.nextPlayer();
    }

    public String toString() {
        return super.getCard().toString() + " : ChooseSuit";
    }
    
}
