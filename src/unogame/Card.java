package unogame;

public class Card {
    private String color;
    private int value;

    public Card(String color, int value) {
        this.color = color;
        this.value = value;
    }
      

public boolean matches(Card other) {
    return this.getColor().equals(other.getColor()) || this.getValue() == other.getValue();
}


    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
