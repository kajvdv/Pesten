package pesten;

public interface PestenInterface {
    public void showHand(CardContainer hand);
    public void showBoard(CardContainer drawStack, CardContainer gameStack);
    public void showOtherHands(int handCount[]);
    public void printMessage(String message);
    public int getChoose();
}