package edu.brandeis.cosi103a.ip1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test by function for the functions of the dice game in App.java
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
@Test
public void testPlayerStartingDeck() {
    Player player = new Player();
    Supply supply = new Supply();
    player.addStartingDeck(supply.setupStartingDeck());
    
    int bitcoinCount = 0;
    int methodCount = 0;
    
    for (Card card : player.deck.allCards) {
        if (card instanceof Bitcoin) {
            bitcoinCount++;
        } else if (card instanceof Method) {
            methodCount++;
        }
    }
    
    assertTrue("Player should have 7 bitcoins", bitcoinCount == 7);
    assertTrue("Player should have 3 methods", methodCount == 3);
    assertTrue("Starting deck should have 10 cards total", player.deck.allCards.size() == 10);
}

@Test
public void testPlayerStartingHand() {
    Player player = new Player();
    Supply supply = new Supply();
    player.addStartingDeck(supply.setupStartingDeck());
    player.deck.refillHand();

    assertTrue("Player should have 5 cards in hand", player.deck.getHand().size() == 5);
}

@Test
public void testRandomStartingPlayer() {
    Player player1 = new Player();
    Player player2 = new Player();
    Supply supply = new Supply();
    player1.addStartingDeck(supply.setupStartingDeck());
    player2.addStartingDeck(supply.setupStartingDeck());

    // Run the selection multiple times to check randomness
    int player1Starts = 0;
    int player2Starts = 0;
    int iterations = 1000; // Number of iterations to test randomness

    for (int i = 0; i < iterations; i++) {
        Player startingPlayer = App.selectStartingPlayer(player1, player2);
        if (startingPlayer == player1) {
            player1Starts++;
        } else {
            player2Starts++;
        }
    }

    // Check that both players have started at least once
    assertTrue("Player 1 should have started at least once", player1Starts > 0);
    assertTrue("Player 2 should have started at least once", player2Starts > 0);
}

@Test
public void testBuyCardReturnsNullWhenSupplyEmpty() {
    Supply supply = new Supply();
    
    // Drain all cards from supply by buying them
    Card card;
    int maxIterations = 1000; // Safety limit to prevent infinite loops
    int iterations = 0;
    while ((card = supply.buyCard(10)) != null && iterations < maxIterations) {
        iterations++;
    }
    
    // Supply should now be empty
    assertTrue("buyCard should return null when supply is empty", supply.buyCard(10) == null);
}

@Test
public void testGameEndWhenFrameworksExhausted() {
    String result = App.playGame();
    assertTrue("Game should return a winner", result.equals("Player 1 wins") || result.equals("Player 2 wins") || result.equals("Tie"));
}

@Test
public void testPlayerCannotBuyCardWithInsufficientValue() {
    Supply supply = new Supply();
    Player player = new Player();
    player.addStartingDeck(supply.setupStartingDeck());
    
    // Try to buy a card that costs more than player's value
    Card expensiveCard = supply.buyCard(1); // Low value, should fail to buy expensive cards
    assertTrue("buyCard should return null or cheap card with low value", expensiveCard == null || expensiveCard.getCost() <= 1);
}

@Test
public void testCleanupPhaseRefillsHand() {
    Player player = new Player();
    Supply supply = new Supply();
    player.addStartingDeck(supply.setupStartingDeck());
    player.deck.refillHand();
    
    int initialHandSize = player.deck.getHand().size();
    player.cleanup();
    int finalHandSize = player.deck.getHand().size();
    
    assertTrue("Hand should be refilled to 5 cards after cleanup", finalHandSize == 5);
}

@Test
public void testCleanupPhaseDiscardsHandBeforeRefill() {
    Player player = new Player();
    Supply supply = new Supply();
    player.addStartingDeck(supply.setupStartingDeck());
    player.deck.refillHand();
    
    int initialHandSize = player.deck.getHand().size();
    int initialDiscardSize = player.deck.getDiscard().size();
    
    // Perform cleanup
    player.cleanup();
    
    // Hand should be empty after cleanup and then refilled
    assertTrue("Hand should be refilled to 5 cards after cleanup", player.deck.getHand().size() == 5);
    // Discard pile should have grown by at least the previous hand size
    assertTrue("Previous hand should be discarded", player.deck.getDiscard().size() >= initialDiscardSize + initialHandSize);
}

@Test
public void testBoughtCardGoesToDiscardPile() {
    Player player = new Player();
    Supply supply = new Supply();
    player.addStartingDeck(supply.setupStartingDeck());
    player.deck.refillHand();
    
    int initialDiscardSize = player.deck.getDiscard().size();
    
    // Buy a card with sufficient value
    int value = player.calculatePlayValue();
    Card boughtCard = supply.buyCard(value);
    
    if (boughtCard != null) {
        player.deck.addCardToDiscardPile(boughtCard);
        int finalDiscardSize = player.deck.getDiscard().size();
        
        assertTrue("Bought card should be added to discard pile", finalDiscardSize == initialDiscardSize + 1);
        assertTrue("Last card in discard pile should be the bought card", player.deck.getDiscard().get(finalDiscardSize - 1) == boughtCard);
    }
}

@Test
public void testCalculatePlayValue() {
    Player player = new Player();
    Supply supply = new Supply();
    player.addStartingDeck(supply.setupStartingDeck());
    player.deck.refillHand();
    
    int playValue = player.calculatePlayValue();
    
    assertTrue("Play value should be at least 1 (minimum bitcoin value)", playValue >= 1);
    assertTrue("Play value should be reasonable", playValue <= 100);
}


}
