package pesten.pestencards.takecards;

import java.util.ArrayList;

import pesten.*;

public class TakeCard extends PestenCard {

    private DrawCounter counter;
    private int drawCount;
    private static ArrayList<TakeCard> takeCards = new ArrayList<TakeCard>();

    // Cast the PestenCard to a TakeCard. If card is not a TakeCard, it will return null
    private static TakeCard castToTakeCard(PestenCard card) {
        if (takeCards.contains(card)) {
            return takeCards.get(takeCards.indexOf(card));
        }
        else {
            return null;
        }
    }
    
    public TakeCard(Card card, int drawCount, DrawCounter counter) {
        super(card);
        this.drawCount = drawCount;
        this.counter = counter;
        takeCards.add(this);
    }

    // If player can't play a card it should take 
    @Override
    public void onDraw(Pesten game) {
        if (counter.getCount() > 0) {
            for (int i = counter.getCount(); i > 0; i--) {
                game.drawCard();
            }
        }
        else {
            super.onDraw(game);
        }
    }

    @Override
    public boolean onCheck(Pesten game, PestenCard playedCard) {
        TakeCard playedTakeCard = castToTakeCard(playedCard);
        if (playedTakeCard == null) return false;
        if (playedTakeCard.counter == this.counter && super.onCheck(game, playedTakeCard)) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onNext(Pesten game) {
        counter.increment(drawCount);
        game.getInterface().printMessage("The next player should draw " + counter.getCount() + " cards.");
        game.nextPlayer();
    }

}
