package edu.brandeis.cosi103a.ip1;


public class App 
{
    public static void main( String[] args )
    {
        
    }

    /**
    * A method that plays a game similar to dominion but with cryptocurrency-themed cards (similar to coins) and automation
    * cards (similar to cards worth victory points). The game supports 2 players and is automated - the game is played by the computer.
    * Players each begin with 7 bitcoins and 3 methods. These are handed out at the beginning of the game from the supply. 
    * The players shuffle their starting deck and draws 5 facedown cards that make up their starting hand. The starting player is chosen at random.
    * Each turn has 2 phases: the buy phase and the cleanup phase. During the buy phase, the player plays cryptocurrency cards from their hand, and may buy
    * one card up to the value of the cryptocurrency played. Bought cards go directly into the player's discard pile. During the cleanup phase, the player discards
    * their hand and all played cards, and deals a new hand from their deck. Before dealing begins, the previous hand should be added to the discard pile.
    * When dealing a new hand, cards are dealt from the players draw pile until it is empty. When the draw pile is empty, the discard pile is shuffled and becomes the
    * draw pile. The game ends when all framework cards have been bought. The player with the highest total value of automation cards in their deck wins.
    * 
    * There are 14 method cards, 8 module cards, 8 framework cards, 60 bitcoin cards, 40 ethereum cards, and 30 dogecoin cards. After cards are played, they remain in thr player's deck.
    */
    public static void playGame() {
        Player player1 = new Player();
        Player player2 = new Player();
        // Initialize supply deck
        Supply supply = new Supply();

        // Deal starting hands
        player1.setupStartingDeck(supply);
        player2.setupStartingDeck(supply);

        // Game loop
        Player currentPlayer = player1;
        Player otherPlayer = player2;

        while (supply.getFrameworkCount() > 0) {
            // Buy phase
            int value = currentPlayer.calculatePlayValue();
            currentPlayer.buyCard(supply, value);
            
            // Cleanup phase
            currentPlayer.cleanup();
            
            // Switch players
            Player temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
        }

        // Determine winner
        int player1Score = player1.getAutomationValue();
        int player2Score = player2.getAutomationValue();

        if (player1Score > player2Score) {
            return "Player 1";
        } else if (player2Score > player1Score) {
            return "Player 2";
        } else {
            return "Tie";
        }
    }


}

