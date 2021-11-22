package pesten;

public class Pesten {

    private CardContainer drawStack;
    private CardContainer gameStack = new CardContainer();
    private Player currentPlayer;
    private boolean isWon = false;
    private PestenInterface playerInterface;

    public Pesten(Player startingPlayer, CardContainer cardStack) {
        this.currentPlayer = startingPlayer;
        drawStack = cardStack;
        drawStack.giveTopCardTo(gameStack);
        Player p = startingPlayer;
        do {
            for (int i = 0; i < 8; i++) {
                drawStack.giveTopCardTo(p);
            }
            p = p.getNextPlayer();
        } while (p != startingPlayer);
    }

    public void drawCard() {
        CardContainer player = currentPlayer;
        player.takeTopCardFrom(drawStack);
    }

    public void nextPlayer() {
        currentPlayer = currentPlayer.getNextPlayer();
    }

    public void playTurn(PestenInterface user) {
        CardContainer currentPlayerHand = currentPlayer;
        playerInterface = user;
        user.printMessage("It's " + currentPlayer.getName() + "'s turn.");
        user.showBoard(drawStack, gameStack);
        user.showHand(currentPlayer);
        int choosenCard = user.getChoose();
        if (choosenCard == -1) {
            // drawCard
            gameStack.getTopCard().onDraw(this);
        } 
        else {
            // checkCard
            PestenCard playedCard = currentPlayer.getCardAt(choosenCard);
            if (gameStack.getTopCard().onCheck(this, playedCard)) {
                // playCard
                currentPlayer.giveCardTo(gameStack, choosenCard);
                if (currentPlayerHand.isEmpty() || isWon) {
                    isWon = true;
                }
                else {
                    gameStack.getTopCard().onNext(this);
                }
            }
            else {
                user.printMessage("Invalid Card, play again");
            }
        }
    }

    public boolean getWinStatus() {
        return isWon;
    }

    public PestenInterface getInterface() {
        return playerInterface;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}