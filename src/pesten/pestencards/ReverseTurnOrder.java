package pesten.pestencards;

import pesten.*;

public class ReverseTurnOrder extends PestenCard {

    public ReverseTurnOrder(Card card) {
        super(card);
    }

    @Override
    public void onNext(Pesten game) {
        PestenInterface user = game.getInterface();
        game.getCurrentPlayer().reverseOrder();
        user.printMessage("Turn reversed!");
        game.nextPlayer();
    }

    @Override
    public String toString() {
        return super.toString() + " : Reverse turn order";
    }
    
}
