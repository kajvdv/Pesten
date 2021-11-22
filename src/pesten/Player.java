package pesten;

public class Player extends CardContainer {

    private String name = "Player";
    private Player next;
    private Player previous;

    public Player(String name) {
        this.name = name;
        this.next = this;
        this.previous = this;
    }

    public Player(String name, Player previous) {
        this.name = name;
        this.previous = previous;
        this.next = previous.next;
        previous.next = this;
        this.next.previous = this;
    }

    public String getName() {
        return this.name;
    }

    public void reverseOrder() {
        Player i = this;
        do {
            Player temp = i.next;
            i.next = i.previous;
            i.previous = temp;
            i = i.next;
        } while (i != this);
    }

    public Player getNextPlayer() {
        return next;
    }

}