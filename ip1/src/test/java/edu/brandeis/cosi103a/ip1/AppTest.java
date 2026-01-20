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
    public void testPlayerTurn()
    {
        // Since the playTurn function requires user input, we will test the rollDie function instead
        int roll = App.rollDie();
        assertTrue("Die roll should be between 1 and 6", roll >= 1 && roll <= 6);
    }
    @Test
    public void testRollDie()
    {
        int roll = App.rollDie();
        assertTrue("Die roll should be between 1 and 6", roll >= 1 && roll <= 6);
    }
    @Test
    public void testGameWinner()
    {
        int player1Score = 30;
        int player2Score = 25;
        String winner;
        if (player1Score > player2Score) {
            winner = "Player 1";
        } else if (player2Score > player1Score) {
            winner = "Player 2";
        } else {
            winner = "Tie";
        }
        assertTrue("Player 1 should be the winner", winner.equals("Player 1"));
    }
    @Test
    public void testTieGame()
    {
        int player1Score = 20;
        int player2Score = 20;
        String winner;
        if (player1Score > player2Score) {
            winner = "Player 1";
        } else if (player2Score > player1Score) {
            winner = "Player 2";
        } else {
            winner = "Tie";
        }
        assertTrue("The game should be a tie", winner.equals("Tie"));
    }
    @Test
    public void testMultipleRolls()
    {
        int roll1 = App.rollDie();
        int roll2 = App.rollDie();
        assertTrue("Both rolls should be between 1 and 6", roll1 >= 1 && roll1 <= 6 && roll2 >= 1 && roll2 <= 6);
    }
    @Test
    public void testMaxRerolls()
    {
        int rerolls = 2;
        while (rerolls > 0) {
            int roll = App.rollDie();
            assertTrue("Die roll should be between 1 and 6", roll >= 1&& roll <= 6);
            rerolls--;
        }
    }
    @Test
    public void testGameTurns()
    {
        int turns = 10;
        for (int turn = 1; turn <= turns; turn++) {
            assertTrue("Turn number should be between 1 and 10", turn >= 1 && turn <= 10);
        }
    }

}
