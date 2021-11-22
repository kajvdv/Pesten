package pesten.pestencards;

import pesten.*;

public class OneMoreTime extends PestenCard {

    public OneMoreTime(Card card) {
        super(card);
    }

    @Override
    public void onNext(Pesten game) {
        PestenInterface user = game.getInterface();
        user.printMessage("You may play one more time");
    }

    @Override
    public String toString() {
        return super.toString() + " : One more time";
    }
    
}
