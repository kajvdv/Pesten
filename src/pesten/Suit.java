package pesten;

public enum Suit {
    HARTEN("Harten"), 
    RUITEN("Ruiten"),
    KLAVER("Klaver"),
    SCHOPPEN("Schoppen"),
    EMPTY("");

    private String name;

    private Suit(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}