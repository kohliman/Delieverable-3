package unogame;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] colors = { "red", "yellow", "green", "blue" };
        int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        for (String color : colors) {
            for (int value : values) {
                cards.add(new Card(color, value));
                if (value != 0) {
                    cards.add(new Card(color, value));
                }
            }
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }

    public int getSize() {
        return cards.size();
    }
}
