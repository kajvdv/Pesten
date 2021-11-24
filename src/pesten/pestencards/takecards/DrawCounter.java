package pesten.pestencards.takecards;

public class DrawCounter {

    private int counter = 0;

    public void increment(int amount) {
        counter += amount;
    }

    public int getCount() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }
    
}
