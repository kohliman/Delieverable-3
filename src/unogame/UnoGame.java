package unogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnoGame {
    private ArrayList<Player> players;
    private Deck deck;
    private Card discardPile;
    private boolean gameEnd;

    public UnoGame() {
        players = new ArrayList<>();
        deck = new Deck();
        discardPile = deck.drawCard();
        gameEnd = false;
    }
    
     public boolean isGameEnd() {
        return gameEnd;
    }

    public boolean hasPlayer(Player player) {
        return players.contains(player);
    }

    public boolean canPlay(Player player) {
        for (Card card : player.getHand()) {
            if (card.matches(discardPile)) {
                return true;
            }
        }
        return false;
    }

 
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        while (!gameEnd) {
            for (Player player : players) {
                if (gameEnd) {
                    break;
                }
                System.out.println(player.getName() + ", it's your turn.");
                System.out.println("The card on the discard pile is " + discardPile);
                player.play(discardPile, deck);
                if (player.getHandSize() == 0) {
                    System.out.println(player.getName() + " wins!");
                    gameEnd = true;
                    break;
                }
            }
        }
        showScore();
    }

    private void showScore() {
        System.out.println("Final Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            UnoGame game = new UnoGame();

            System.out.println("Enter the number of players:");
            int numPlayers = scanner.nextInt();
            for (int i = 1; i <= numPlayers; i++) {
                System.out.println("Enter the name of player " + i + ":");
                String name = scanner.next();
                game.addPlayer(new Player(name));

            }
            game.startGame();

            System.out.println("Do you want to play again? (y/n)");
            String input = scanner.next();
            playAgain = input.equalsIgnoreCase("y");
        }
    }
    public List<Player> getPlayers() {
    return players;
}

    void play() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    

}
