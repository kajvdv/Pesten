package pesten;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInterface implements PestenInterface {

    Scanner scanner = new Scanner(System.in);

    public void showHand(CardContainer hand) {
        ArrayList<PestenCard> cardArray = hand.getCards();
        int i = 1;
        for (PestenCard card : cardArray) {
            System.out.println(i + ": " + card.toString());
            i++;
        }
    }

    public void showBoard(CardContainer drawStack, CardContainer gameStack) {
        System.out.println("The top card is: " + gameStack.getTopCard());
    }

    public void showOtherHands(int handCount[]) {}

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int getChoose() {
        int choose = scanner.nextInt();
        choose--;
        return choose;
    }

    public Suit getSuitChoose() {
        System.out.println("Choose a suit:");
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1 + ": " + Suit.values()[i].toString());
        }
        int choose = scanner.nextInt();
        choose--;
        return Suit.values()[choose];
    }
}