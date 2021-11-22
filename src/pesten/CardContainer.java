package pesten;

import java.util.ArrayList;
import java.util.Collections;

public class CardContainer {

    protected ArrayList<PestenCard> cards = new ArrayList<PestenCard>();

    public void giveCardTo(CardContainer otherContainer, int index) {
        otherContainer.cards.add(cards.get(index));
        cards.remove(index);
    }

    public void giveTopCardTo(CardContainer otherContainer) {
        giveCardTo(otherContainer, cards.size() - 1);
    }

    public void takeCardFrom(CardContainer otherContainer, int index) {
        cards.add(otherContainer.cards.get(index));
        otherContainer.cards.remove(index);
    }

    public void takeTopCardFrom(CardContainer otherContainer) {
        takeCardFrom(otherContainer, otherContainer.cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.size() == 0;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public ArrayList<PestenCard> getCards() {
        return cards;
    }

    public PestenCard getCardAt(int index) {
        return cards.get(index);
    }

    public PestenCard getTopCard() {
        return cards.get(cards.size() - 1);
    }

    public void addCard(PestenCard card) {
        cards.add(card);
    }

}