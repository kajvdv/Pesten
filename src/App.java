import pesten.*;
import pesten.pestencards.*;
import pesten.pestencards.takecards.*;

public class App {
    
    public static void main(String[] args) {
        Player p = new Player("Player4", new Player("Player3", new Player("Player2", new Player("Player1"))));
        p = p.getNextPlayer();
        CardContainer deck = new CardContainer();
        // Fill deck with cards
        DrawCounter counter = new DrawCounter();
        for (int suit = 0; suit < 4; suit++) {
            for (int val = 0; val < 13; val++) {
                PestenCard pestenCard;
                Card card = new Card(Suit.values()[suit], Value.values()[val]);
                if (card.getValue() == Value.ZEVEN || card.getValue() == Value.KONING) {
                    pestenCard = new OneMoreTime(card);
                }
                else if (card.getValue() == Value.ACHT) {
                    pestenCard = new SkipTurn(card);
                }
                else if (card.getValue() == Value.AAS) {
                    pestenCard = new ReverseTurnOrder(card);
                }
                else if (card.getValue() == Value.BOER) {
                    pestenCard = new ChooseSuit(card);
                }
                else if (card.getValue() == Value.TWEE) {
                    pestenCard = new TakeCard(card, 2, counter);
                }
                else {
                    pestenCard = new PestenCard(card);
                }
                deck.addCard(pestenCard);
            }
        }
        for (int i = 0; i < 3; i++) {
            deck.addCard(new TakeCard(new Joker(), 5, counter));
        }
        // End filling deck
        deck.shuffle();
        Pesten game = new Pesten(p, deck);
        PestenInterface user = new ConsoleInterface();
        while(game.getWinStatus() == false) {
            game.playTurn(user);
        }
    }
}