package unogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getHandSize() {
        return hand.size();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        return hand.remove(index);
    }

    public void play(Card discardPile, Deck deck) {
        System.out.println("Your hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + ": " + hand.get(i));
        }
        boolean played = false;
        while (!played) {
            System.out.println("Enter the index of the card you want to play or type 'draw' to draw a card:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            if (input.equalsIgnoreCase("draw")) {
                Card newCard = deck.drawCard();
                System.out.println("You drew " + newCard);
                if (newCard.getColor().equals(discardPile.getColor()) || newCard.getValue() == discardPile.getValue()) {
                    System.out.println("You can play your new card!");
                    hand.add(newCard);
                    played = true;
                } else {
                    System.out.println("You cannot play your new card.");
                }
            } else {
                int index = Integer.parseInt(input);
                Card card = hand.get(index);
                if (card.getColor().equals(discardPile.getColor()) || card.getValue() == discardPile.getValue()) {
                    discardPile = card;
                    hand.remove(index);
                    System.out.println("You played " + card);
                    played = true;
                    updateScore(card);
                } else {
                    System.out.println("You cannot play " + card);
                }
            }
        }
    }

    private void updateScore(Card card) {
        score += card.getValue();
        if (card.getValue() == 11) {
            UnoGame unoGame = new UnoGame();
List<Player> players = unoGame.getPlayers();
for (Player player : players) {


                if (!player.equals(this)) {
                    player.updateScore(11);
                }
            }
        }
    }

    private void updateScore(int value) {
        score += value;
    }

    public int getScore() {
        return score;
    }
    public List<Card> getHand() {
    return hand;
}
}
