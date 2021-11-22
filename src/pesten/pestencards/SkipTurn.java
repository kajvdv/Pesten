package pesten.pestencards;

import pesten.*;

public class SkipTurn extends PestenCard {
    
    public SkipTurn(Card card) {
        super(card);
    }

    @Override
    public void onNext(Pesten game) {
        PestenInterface user = game.getInterface();
        game.nextPlayer();
        user.printMessage(game.getCurrentPlayer().getName() + " skips a turn");
        game.nextPlayer();
    }

    @Override
    public String toString() {
        return super.toString() + " : SkipTurn";
    }

}
